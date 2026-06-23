/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.law.stockade.ROOM_STOCKADE;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ 
/*     */ class Jail
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*  24 */   private final ROOM_STOCKADE b = (SETT.ROOMS()).STOCKADE; private final AIPLAN.PLANRES.Resumer init; private final AIPLAN.PLANRES.Resumer walkToDoor; private final AIPLAN.PLANRES.Resumer sleep;
/*  25 */   private static CharSequence ¤¤name = "In Stockade"; private final AIPLAN.PLANRES.Resumer poop; private final AIPLAN.PLANRES.Resumer eat; private final AIPLAN.PLANRES.Resumer changeSpot;
/*     */   static {
/*  27 */     D.ts(Jail.class);
/*     */   }
/*     */   public Jail() {
/*  30 */     super("prisJail");
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
/*  47 */     this.init = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  51 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  58 */           if (d.planByte1 <= 0) {
/*  59 */             return null;
/*     */           }
/*  61 */           d.planByte1 = (byte)(d.planByte1 - 1);
/*     */           
/*  63 */           if (!Jail.this.b.isWithin(d.planTile.x(), d.planTile.y(), a.tc())) {
/*  64 */             return Jail.this.walkToDoor.set(a, d);
/*     */           }
/*     */           
/*  67 */           if ((NEEDS.TYPES()).HUNGER.stat().getPrio(a.indu()) > 0) {
/*  68 */             AISUB.AISubActivation s = Jail.this.eat.set(a, d);
/*  69 */             if (s != null) {
/*  70 */               return s;
/*     */             }
/*     */           } 
/*  73 */           if (TIME.light().nightIs()) {
/*  74 */             AISUB.AISubActivation s = Jail.this.sleep.set(a, d);
/*  75 */             if (s != null) {
/*  76 */               return s;
/*     */             }
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/*  82 */           if (RND.oneIn(5))
/*     */           {
/*  84 */             if (RND.oneIn(8)) {
/*  85 */               AISUB.AISubActivation s = Jail.this.poop.set(a, d);
/*  86 */               if (s != null)
/*  87 */                 return s; 
/*     */             } else {
/*  89 */               AISUB.AISubActivation s = Jail.this.changeSpot.set(a, d);
/*  90 */               if (s != null) {
/*  91 */                 return s;
/*     */               }
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*  97 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 102 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 112 */     this.walkToDoor = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 116 */           return (AI.SUBS()).walkTo.room(a, d, (RoomInstance)Jail.this.b.getter.get((COORDINATE)d.planTile));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 121 */           return Jail.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 126 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 136 */     this.sleep = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 140 */           return (AI.SUBS()).subSleep.activate(a, d);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 146 */           return Jail.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 151 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 161 */     this.poop = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 165 */           COORDINATE c = Jail.this.b.latrineReserve((COORDINATE)d.planTile);
/* 166 */           d.planByte2 = 0;
/* 167 */           if (c != null) {
/* 168 */             d.planTile.set(c);
/* 169 */             AISUB.AISubActivation ss = (AI.SUBS()).walkTo.cooFull(a, d, c.x(), c.y());
/* 170 */             if (ss != null)
/* 171 */               return ss; 
/* 172 */             Jail.this.b.latrineUse((COORDINATE)d.planTile, false);
/*     */           } 
/* 174 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 179 */           if (d.planByte2 == 0) {
/* 180 */             d.planByte2 = 1;
/* 181 */             return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */           } 
/* 183 */           Jail.this.b.latrineUse((COORDINATE)d.planTile, true);
/* 184 */           return Jail.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 189 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 194 */           Jail.this.b.latrineUse((COORDINATE)d.planTile, false);
/*     */         }
/*     */       };
/*     */     
/* 198 */     this.eat = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 202 */           COORDINATE c = Jail.this.b.foodReserve((COORDINATE)d.planTile);
/* 203 */           d.planByte2 = 0;
/* 204 */           if (c != null) {
/* 205 */             d.planTile.set(c);
/* 206 */             AISUB.AISubActivation ss = (AI.SUBS()).walkTo.cooFull(a, d, c.x(), c.y());
/* 207 */             if (ss != null)
/* 208 */               return ss; 
/* 209 */             Jail.this.b.foodUse((COORDINATE)d.planTile, false);
/*     */           } 
/* 211 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 216 */           STATS.FOOD().eat(a, 0, 0.0D);
/* 217 */           (NEEDS.TYPES()).HUNGER.stat().fix(a.indu());
/* 218 */           if (d.planByte2 == 0) {
/* 219 */             d.planByte2 = 1;
/* 220 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.grab, 3.0D);
/*     */           } 
/* 222 */           Jail.this.b.foodUse((COORDINATE)d.planTile, true);
/* 223 */           return Jail.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 228 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 233 */           Jail.this.b.foodUse((COORDINATE)d.planTile, false);
/*     */         }
/*     */       };
/*     */     
/* 237 */     this.changeSpot = new AIPLAN.PLANRES.Resumer(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 241 */           DIR dir = (DIR)DIR.ORTHO.rnd();
/* 242 */           int dx = a.tc().x() + dir.x();
/* 243 */           int dy = a.tc().y() + dir.y();
/* 244 */           if (Jail.this.b.isWithin(dx, dy, a.tc()) && 
/* 245 */             !SETT.ENTITIES().hasAtTile(dx, dy)) {
/* 246 */             return (AI.SUBS()).walkTo.cooFull(a, d, dx, dy);
/*     */           }
/* 248 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 253 */           return Jail.this.init.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 258 */           return true;
/*     */         } public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     RoomInstance ins = this.b.registerPrisoner(a.tc());
/*     */     if (ins == null)
/*     */       return null; 
/*     */     d.planTile.set(ins.mX(), ins.mY());
/*     */     (STATS.NEEDS()).EXPOSURE.fix(a.indu());
/*     */     d.planByte1 = 8;
/*     */     return this.init.set(a, d);
/*     */   } public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 270 */     if (e.event == HEvent.ROOM_REMOVED && e.room.blueprintI() == this.b && e.room.is((COORDINATE)d.planTile)) {
/*     */       
/* 272 */       d.overwrite(a, (AI.plans()).NOP);
/* 273 */       return true;
/*     */     } 
/* 275 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void cancel(Humanoid a, AIManager d) {
/* 280 */     this.b.unregisterPrisoner((COORDINATE)d.planTile);
/* 281 */     super.cancel(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation resume(Humanoid a, AIManager d) {
/* 286 */     AISUB.AISubActivation s = super.resume(a, d);
/* 287 */     if (s == null)
/* 288 */       this.b.unregisterPrisoner((COORDINATE)d.planTile); 
/* 289 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean shouldContinue(Humanoid a, AIManager d) {
/* 294 */     return super.shouldContinue(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/* 299 */     string.add(¤¤name);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\Jail.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */