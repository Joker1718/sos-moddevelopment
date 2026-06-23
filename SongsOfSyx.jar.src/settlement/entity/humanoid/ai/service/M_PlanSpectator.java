/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATES;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.main.AISUBS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class M_PlanSpectator
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   public final LIST<? extends ROOM_SPECTATOR.ROOM_SPECTATOR_HASER> services;
/*  31 */   private static CharSequence ¤¤waiting = "Waiting for {0}"; private final R walk; private final R move; private final R stand; private final R cheer; private final R boo;
/*     */   
/*     */   static {
/*  34 */     D.ts(M_PlanSpectator.class);
/*     */   }
/*     */   
/*     */   M_PlanSpectator(String key, LIST<? extends ROOM_SPECTATOR.ROOM_SPECTATOR_HASER> services) {
/*  38 */     super("SerSpec_" + key);
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
/*  52 */     this.walk = new R(this)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  57 */           COORDINATE c = (M_PlanSpectator.this.s(d).service()).finder.reserve(a.tc(), (M_PlanSpectator.this.s(d).service()).radius);
/*  58 */           if (c == null)
/*  59 */             return null; 
/*  60 */           d.planTile.set(c);
/*  61 */           ROOM_SPECTATOR s = M_PlanSpectator.this.s(d);
/*  62 */           c = s.getDestination(c);
/*  63 */           AISUB.AISubActivation sub = (AI.SUBS()).walkTo.cooFull(a, d, c);
/*  64 */           if (sub == null) {
/*  65 */             can(a, d);
/*  66 */             return null;
/*     */           } 
/*  68 */           s.service().reportDistance(a);
/*  69 */           s.service().reportAccess(a, (COORDINATE)d.planTile);
/*     */           
/*  71 */           s.doSomeThingExtraWhenAccess(a);
/*  72 */           return sub;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  77 */           d.planByte1 = (byte)(8 + RND.rInt(8));
/*  78 */           return M_PlanSpectator.this.move.set(a, d);
/*     */         }
/*     */       };
/*     */     
/*  82 */     this.move = new R(this)
/*     */       {
/*  84 */         private final int[] order = new int[] { 0, 1, 2 };
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  89 */           if (!shouldMove(a, a.tc().x(), a.tc().y())) {
/*  90 */             return M_PlanSpectator.this.stand.set(a, d);
/*     */           }
/*     */           
/*  93 */           ROOM_SPECTATOR s = M_PlanSpectator.this.s(d);
/*  94 */           DIR dd = DIR.get(a.body().cX(), a.body().cY(), s.lookAt(d.planTile.x(), d.planTile.y())); byte b;
/*     */           int i, arrayOfInt[];
/*  96 */           for (i = (arrayOfInt = this.order).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/*  97 */             dd = dd.next(j);
/*  98 */             int dx = a.tc().x() + dd.x();
/*  99 */             int dy = a.tc().y() + dd.y();
/* 100 */             if (M_PlanSpectator.this.isSpot(dx, dy) && 
/* 101 */               !shouldMove(a, dx, dy)) {
/* 102 */               return (AI.SUBS()).walkTo.cooFull(a, d, dx, dy);
/*     */             }
/*     */             
/*     */             b++; }
/*     */           
/* 107 */           return M_PlanSpectator.this.stand.set(a, d);
/*     */         }
/*     */         
/*     */         private boolean shouldMove(Humanoid a, int cx, int cy) {
/* 111 */           for (ENTITY e : SETT.ENTITIES().getAtTile(cx, cy)) {
/* 112 */             if (e != a && e instanceof Humanoid && e.speed.magnitude() == 0.0D)
/* 113 */               return true; 
/*     */           } 
/* 115 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 120 */           return M_PlanSpectator.this.stand.set(a, d);
/*     */         }
/*     */       };
/*     */     
/* 124 */     this.stand = new R(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 128 */           ROOM_SPECTATOR s = M_PlanSpectator.this.s(d);
/* 129 */           if (!s.is(d.planTile.x(), d.planTile.y())) {
/* 130 */             return null;
/*     */           }
/* 132 */           if (d.planByte1 <= 0) {
/* 133 */             if (!AIModules.current(d).moduleCanContinue(a, d) || RND.oneIn(5)) {
/* 134 */               can(a, d);
/* 135 */               return null;
/*     */             } 
/*     */           } else {
/*     */             
/* 139 */             FINDABLE f = (s.service()).finder.getReserved(d.planTile.x(), d.planTile.y());
/* 140 */             if (f == null) {
/* 141 */               f = (s.service()).finder.getReservable(d.planTile.x(), d.planTile.y());
/* 142 */               if (f == null) {
/* 143 */                 d.planByte1 = (byte)(d.planByte1 - 3);
/*     */               } else {
/* 145 */                 f.findableReserve();
/*     */               } 
/*     */             } 
/* 148 */             d.planByte1 = (byte)(d.planByte1 - 1);
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 154 */           DIR dd = DIR.get(a.body().cX(), a.body().cY(), s.lookAt(d.planTile.x(), d.planTile.y()));
/* 155 */           if (RND.oneIn(5))
/* 156 */             dd = dd.next(RND.rInt0(1)); 
/* 157 */           a.speed.setDirCurrent(dd);
/*     */           
/* 159 */           if (s.shouldCheer(d.planTile.x(), d.planTile.y())) {
/* 160 */             return M_PlanSpectator.this.cheer.set(a, d);
/*     */           }
/*     */           
/* 163 */           if (s.shouldBoo(d.planTile.x(), d.planTile.y())) {
/* 164 */             return M_PlanSpectator.this.boo.set(a, d);
/*     */           }
/*     */ 
/*     */           
/* 168 */           return (AI.SUBS()).STAND.activateTime(a, d, 10);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 174 */           return M_PlanSpectator.this.move.set(a, d);
/*     */         }
/*     */       };
/*     */     
/* 178 */     this.cheer = new R(this)
/*     */       {
/* 180 */         private AISTATES.Animation[] anima = new AISTATES.Animation[] {
/* 181 */             (AI.STATES()).anima.wave, 
/* 182 */             (AI.STATES()).anima.box, 
/* 183 */             (AI.STATES()).anima.lay, 
/* 184 */             (AI.STATES()).anima.stand
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 190 */           return (AI.SUBS()).single.activate(a, d, this.anima[RND.rInt(this.anima.length)], (2 + RND.rInt(4)));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 197 */           return M_PlanSpectator.this.stand.set(a, d);
/*     */         }
/*     */       };
/*     */     
/* 201 */     this.boo = new R(this)
/*     */       {
/*     */         private final AISUB ss;
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
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 224 */           if (RND.oneIn(5))
/* 225 */             return this.ss.activate(a, d); 
/* 226 */           if (RND.oneIn(2))
/* 227 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.fist, 4.0D); 
/* 228 */           return (AI.SUBS()).STAND.activateTime(a, d, 4);
/*     */         }
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 233 */           return M_PlanSpectator.this.stand.set(a, d);
/*     */         }
/*     */       };
/*     */     this.services = services;
/*     */   } private boolean isSpot(int tx, int ty) {
/* 238 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 239 */       return false; 
/* 240 */     if ((SETT.ROOMS()).map.is(tx, ty))
/* 241 */       return false; 
/* 242 */     AVAILABILITY av = (SETT.PATH()).availability.get(tx, ty);
/* 243 */     if (av.player >= 0.0D && av.player < 2.0D && av.from == 0.0D) {
/* 244 */       return true;
/*     */     }
/* 246 */     return false;
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */   private ROOM_SPECTATOR s(AIManager d) {
/*     */     return ((ROOM_SPECTATOR.ROOM_SPECTATOR_HASER)this.services.get(d.planByte3)).spec();
/*     */   }
/*     */   private abstract class R extends AIPLAN.PLANRES.Resumer { protected R() {
/* 254 */       super(M_PlanSpectator.this, "");
/*     */     }
/*     */ 
/*     */     
/*     */     protected void name(Humanoid a, AIManager d, Str string) {
/* 259 */       ROOM_SPECTATOR s = M_PlanSpectator.this.s(d);
/* 260 */       if (s != null && s.isActive(d.planTile.x(), d.planTile.y())) {
/* 261 */         string.add((s.service()).verb);
/* 262 */       } else if (s.service().room().employment() != null) {
/* 263 */         string.add(M_PlanSpectator.¤¤waiting).insert(0, (s.service().room().employment()).title);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean con(Humanoid a, AIManager d) {
/* 269 */       ROOM_SPECTATOR s = M_PlanSpectator.this.s(d);
/* 270 */       return (s != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public void can(Humanoid a, AIManager d) {
/* 275 */       ROOM_SPECTATOR s = M_PlanSpectator.this.s(d);
/* 276 */       if (s != null) {
/* 277 */         FINDABLE f = (s.service()).finder.getReserved(d.planTile.x(), d.planTile.y());
/* 278 */         if (f != null)
/* 279 */           f.findableReserveCancel(); 
/*     */       } 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanSpectator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */