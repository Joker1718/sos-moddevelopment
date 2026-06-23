/*     */ package settlement.entity.humanoid;
/*     */ 
/*     */ import game.audio.AUDIO;
/*     */ import game.audio.SoundRace;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.CAUSE_ARRIVE;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.CRIMES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ECollision;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.thing.DRAGGABLE;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimple;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Humanoids
/*     */   extends SETT.SettResource
/*     */ {
/*     */   public final SoundRace sound;
/*     */   public final DRAGGABLE.DRAGGABLE_HOLDER draggable;
/*     */   
/*     */   public Humanoids() {
/*  60 */     super("SETT_HUMANOIDS", false); AI.init(); this.sound = AUDIO.race("BODY_EXPLODE"); this.draggable = new DRAGGABLE.DRAGGABLE_HOLDER() { public DRAGGABLE draggable(int index) { ENTITY e = SETT.ENTITIES().getByID(index); if (e != null && e instanceof Humanoid) { Humanoid a = (Humanoid)e; return a; }  return null; } }
/*  61 */       ; LinkedList<PLACABLE> all = new LinkedList();
/*  62 */     HTYPE[] tt = {
/*  63 */         HTYPES.SUBJECT(), HTYPES.PRISONER(), HTYPES.SLAVE(), HTYPES.CHILD(), HTYPES.DERANGED(), HTYPES.ENEMY(), HTYPES.RIOTER() }; byte b; int i;
/*     */     HTYPE[] arrayOfHTYPE1;
/*  65 */     for (i = (arrayOfHTYPE1 = tt).length, b = 0; b < i; ) { HTYPE t = arrayOfHTYPE1[b];
/*  66 */       for (Race r : RACES.all()) {
/*  67 */         Placer p = new Placer(r, t);
/*  68 */         all.add(p);
/*     */       } 
/*     */       b++; }
/*     */     
/*  72 */     PlacableSimple death = new PlacableSimple("kill", "")
/*     */       {
/*  74 */         private CAUSE_LEAVE cause = CAUSE_LEAVES.AGE();
/*  75 */         ArrayList<CLICKABLE> butts = new ArrayList(CAUSE_LEAVES.ALL().size());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/*  98 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 103 */           return (SPRITE)(SPRITES.icons()).m.cancel;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void place(int x, int y) {
/* 109 */           for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 110 */             if (e instanceof Humanoid) {
/* 111 */               ((Humanoid)e).kill(false, this.cause);
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int x, int y) {
/* 119 */           for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 120 */             if (e instanceof Humanoid) {
/* 121 */               return null;
/*     */             }
/*     */           } 
/* 124 */           return E;
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 129 */           return (LIST<CLICKABLE>)this.butts;
/*     */         }
/*     */       };
/*     */     
/* 133 */     PlacableSimple attack = new PlacableSimple("attack", "")
/*     */       {
/* 135 */         private CAUSE_LEAVE cause = CAUSE_LEAVES.SLAYED();
/* 136 */         private final ECollision coll = new ECollision();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/* 142 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 147 */           return (SPRITE)(SPRITES.icons()).m.cancel;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void place(int x, int y) {
/* 153 */           for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 154 */             if (e instanceof Humanoid) {
/* 155 */               kill((Humanoid)e, x, y);
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/*     */         private void kill(Humanoid e, int x, int y) {
/* 162 */           VectorImp vec = new VectorImp();
/* 163 */           double m = vec.set(x, y, e.body().cX(), e.body().cY());
/*     */           
/* 165 */           e.speed.setRaw(vec.nX() * m * 32.0D + e.speed.x(), vec.nY() * m * 32.0D + e.speed.y());
/*     */           
/* 167 */           this.coll.damagetileStrength = 0.0D;
/* 168 */           this.coll.tileMomentum = 0.0D;
/* 169 */           for (int i = 0; i < this.coll.damage.length; i++)
/* 170 */             this.coll.damage[i] = 0.0D; 
/* 171 */           this.coll.dirDot = 1.0D;
/* 172 */           this.coll.dirDotOther = 1.0D;
/* 173 */           this.coll.norX = 0.5D;
/* 174 */           this.coll.norY = 0.5D;
/* 175 */           this.coll.speedHasChanged = true;
/* 176 */           this.coll.other = null;
/* 177 */           e.collide(this.coll);
/* 178 */           if (!e.isRemoved()) {
/* 179 */             e.kill(true, this.cause);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int x, int y) {
/* 185 */           for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 186 */             if (e instanceof Humanoid) {
/* 187 */               return null;
/*     */             }
/*     */           } 
/* 190 */           return E;
/*     */         }
/*     */       };
/*     */     
/* 194 */     all.add(attack);
/* 195 */     all.add(death);
/*     */     
/* 197 */     PlacableSimple explode = new PlacableSimple("explode", "")
/*     */       {
/* 199 */         private CAUSE_LEAVE cause = CAUSE_LEAVES.SLAYED();
/*     */ 
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/* 204 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/* 209 */           return (SPRITE)(SPRITES.icons()).m.cancel;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void place(int x, int y) {
/* 215 */           for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 216 */             if (e instanceof Humanoid) {
/* 217 */               ((Humanoid)e).inflictDamage(10.0D, this.cause);
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int x, int y) {
/* 225 */           for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 226 */             if (e instanceof Humanoid) {
/* 227 */               return null;
/*     */             }
/*     */           } 
/* 230 */           return E;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 235 */     all.add(explode);
/*     */     
/* 237 */     IDebugPanelSett.add("humanoids", (Iterable)new ArrayList((Iterable)all));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Humanoid create(Race r, int tx, int ty, HTYPE t, CAUSE_ARRIVE cause) {
/* 244 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 245 */       throw new RuntimeException("" + tx + " " + tx); 
/* 246 */     int x = tx * 64 + 32;
/* 247 */     int y = ty * 64 + 32;
/* 248 */     return new Humanoid(x, y, r, t, cause);
/*     */   }
/*     */   
/*     */   private class Placer
/*     */     extends PlacableSimple {
/*     */     private final Race r;
/*     */     private final HTYPE f;
/*     */     
/*     */     private Placer(Race r, HTYPE f) {
/* 257 */       super(String.valueOf(r.info.name) + " " + String.valueOf(r.info.name), "");
/* 258 */       this.r = r;
/* 259 */       this.f = f;
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE getIcon() {
/* 264 */       return (SPRITE)(this.r.appearance()).icon;
/*     */     }
/*     */ 
/*     */     
/*     */     public void place(int x, int y) {
/* 269 */       if (isPlacable(x, y) == null) {
/* 270 */         Humanoid a = new Humanoid(x, y, this.r, this.f, CAUSE_ARRIVES.IMMIGRATED());
/* 271 */         if (a != null && this.f == HTYPES.PRISONER()) {
/* 272 */           (STATS.LAW()).prisonerType.set(a.indu(), CRIMES.all(a.indu().clas()).rnd());
/*     */         }
/*     */         return;
/*     */       } 
/*     */     }
/*     */     
/*     */     public CharSequence isPlacable(int x, int y) {
/* 279 */       int x1 = (x - this.r.physics.hitBoxsize() / 2) / 64;
/* 280 */       int x2 = (x + this.r.physics.hitBoxsize() / 2) / 64;
/* 281 */       int y1 = (y - this.r.physics.hitBoxsize() / 2) / 64;
/* 282 */       int y2 = (y + this.r.physics.hitBoxsize() / 2) / 64;
/* 283 */       if (!SETT.IN_BOUNDS(x1, y1) || !SETT.IN_BOUNDS(x2, y2))
/* 284 */         return E; 
/* 285 */       return (!(SETT.PATH()).solidity.is(x1, y1) && !(SETT.PATH()).solidity.is(x2, y1) && 
/* 286 */         !(SETT.PATH()).solidity.is(x1, y2) && !(SETT.PATH()).solidity.is(x2, y2) && 
/* 287 */         SETT.ENTITIES().getAtPoint(x, y) == null) ? null : E;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public PLACABLE getUndo() {
/* 293 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\Humanoids.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */