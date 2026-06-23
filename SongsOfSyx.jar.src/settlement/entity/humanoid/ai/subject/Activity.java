/*     */ package settlement.entity.humanoid.ai.subject;
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
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.service.module.ROOM_ACTIVITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ class Activity
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   public final ROOM_ACTIVITY s;
/*     */   private final CharSequence verb;
/*     */   private final R walk;
/*     */   private final R move;
/*     */   private final R stand;
/*     */   private final R cheer;
/*     */   private final R boo;
/*     */   
/*     */   public Activity(ROOM_ACTIVITY.ROOM_ACTIVITY_HASER t, CharSequence verb) {
/*  34 */     super("ACTIVITY_" + ((RoomBlueprint)t).key);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  44 */     this.walk = new R(this)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  49 */           COORDINATE c = Activity.this.s.finder().reserve(a.tc(), 400);
/*  50 */           if (c == null)
/*  51 */             return null; 
/*  52 */           d.planTile.set(c);
/*  53 */           c = Activity.this.s.getDestination(c);
/*  54 */           AISUB.AISubActivation sub = (AI.SUBS()).walkTo.cooFull(a, d, c);
/*  55 */           if (sub == null) {
/*  56 */             can(a, d);
/*  57 */             return null;
/*     */           } 
/*  59 */           return sub;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  64 */           d.planByte1 = (byte)(8 + RND.rInt(8));
/*  65 */           return Activity.this.move.set(a, d);
/*     */         }
/*     */       };
/*     */     
/*  69 */     this.move = new R(this)
/*     */       {
/*  71 */         private final int[] order = new int[] { 0, 1, 2 };
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  76 */           if (!shouldMove(a, a.tc().x(), a.tc().y())) {
/*  77 */             return Activity.this.stand.set(a, d);
/*     */           }
/*     */           
/*  80 */           DIR dd = DIR.get(a.body().cX(), a.body().cY(), Activity.this.s.lookAt(d.planTile.x(), d.planTile.y())); byte b;
/*     */           int i, arrayOfInt[];
/*  82 */           for (i = (arrayOfInt = this.order).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/*  83 */             dd = dd.next(j);
/*  84 */             int dx = a.tc().x() + dd.x();
/*  85 */             int dy = a.tc().y() + dd.y();
/*  86 */             if (Activity.this.isSpot(dx, dy) && 
/*  87 */               !shouldMove(a, dx, dy)) {
/*  88 */               return (AI.SUBS()).walkTo.cooFull(a, d, dx, dy);
/*     */             }
/*     */             
/*     */             b++; }
/*     */           
/*  93 */           return Activity.this.stand.set(a, d);
/*     */         }
/*     */         
/*     */         private boolean shouldMove(Humanoid a, int cx, int cy) {
/*  97 */           for (ENTITY e : SETT.ENTITIES().getAtTile(cx, cy)) {
/*  98 */             if (e != a && e instanceof Humanoid && e.speed.magnitude() == 0.0D)
/*  99 */               return true; 
/*     */           } 
/* 101 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 106 */           return Activity.this.stand.set(a, d);
/*     */         }
/*     */       };
/*     */     
/* 110 */     this.stand = new R(this)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 114 */           if (!Activity.this.s.is(d.planTile.x(), d.planTile.y())) {
/* 115 */             return null;
/*     */           }
/* 117 */           if (d.planByte1 <= 0) {
/* 118 */             if (!AIModules.current(d).moduleCanContinue(a, d) || RND.oneIn(5)) {
/* 119 */               can(a, d);
/* 120 */               return null;
/*     */             } 
/*     */           } else {
/*     */             
/* 124 */             FINDABLE f = Activity.this.s.finder().getReserved(d.planTile.x(), d.planTile.y());
/* 125 */             if (f == null) {
/* 126 */               f = Activity.this.s.finder().getReservable(d.planTile.x(), d.planTile.y());
/* 127 */               if (f == null) {
/* 128 */                 d.planByte1 = (byte)(d.planByte1 - 3);
/*     */               } else {
/* 130 */                 f.findableReserve();
/*     */               } 
/*     */             } 
/* 133 */             d.planByte1 = (byte)(d.planByte1 - 1);
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 139 */           DIR dd = DIR.get(a.body().cX(), a.body().cY(), Activity.this.s.lookAt(d.planTile.x(), d.planTile.y()));
/* 140 */           if (RND.oneIn(5))
/* 141 */             dd = dd.next(RND.rInt0(1)); 
/* 142 */           a.speed.setDirCurrent(dd);
/*     */           
/* 144 */           if (Activity.this.s.shouldCheer(d.planTile.x(), d.planTile.y())) {
/* 145 */             return Activity.this.cheer.set(a, d);
/*     */           }
/*     */           
/* 148 */           if (Activity.this.s.shouldBoo(d.planTile.x(), d.planTile.y())) {
/* 149 */             return Activity.this.boo.set(a, d);
/*     */           }
/*     */ 
/*     */           
/* 153 */           return (AI.SUBS()).STAND.activateTime(a, d, 10);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 159 */           return Activity.this.move.set(a, d);
/*     */         }
/*     */       };
/*     */     
/* 163 */     this.cheer = new R(this)
/*     */       {
/* 165 */         private AISTATES.Animation[] anima = new AISTATES.Animation[] {
/* 166 */             (AI.STATES()).anima.wave, 
/* 167 */             (AI.STATES()).anima.box, 
/* 168 */             (AI.STATES()).anima.lay, 
/* 169 */             (AI.STATES()).anima.stand
/*     */           };
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 175 */           return (AI.SUBS()).single.activate(a, d, this.anima[RND.rInt(this.anima.length)], (2 + RND.rInt(4)));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 182 */           return Activity.this.stand.set(a, d);
/*     */         }
/*     */       };
/*     */     
/* 186 */     this.boo = new R(this)
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
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 207 */           if (RND.oneIn(5))
/* 208 */             return this.ss.activate(a, d); 
/* 209 */           if (RND.oneIn(2))
/* 210 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.fist, 4.0D); 
/* 211 */           return (AI.SUBS()).STAND.activateTime(a, d, 4);
/*     */         }
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 216 */           return Activity.this.stand.set(a, d); }
/*     */       };
/*     */     this.s = t.spec();
/*     */     this.verb = verb;
/*     */   } private boolean isSpot(int tx, int ty) {
/* 221 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 222 */       return false; 
/* 223 */     if ((SETT.ROOMS()).map.is(tx, ty))
/* 224 */       return false; 
/* 225 */     AVAILABILITY av = (SETT.PATH()).availability.get(tx, ty);
/* 226 */     if (av.player >= 0.0D && av.player < 2.0D && av.from == 0.0D) {
/* 227 */       return true;
/*     */     }
/* 229 */     return false;
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */   
/*     */   private abstract class R extends AIPLAN.PLANRES.Resumer { protected R() {
/* 237 */       super(Activity.this, "");
/*     */     }
/*     */ 
/*     */     
/*     */     protected void name(Humanoid a, AIManager d, Str string) {
/* 242 */       if (Activity.this.s != null) {
/* 243 */         string.add(Activity.this.verb);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean con(Humanoid a, AIManager d) {
/* 248 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void can(Humanoid a, AIManager d) {
/* 254 */       FINDABLE f = Activity.this.s.finder().getReserved(d.planTile.x(), d.planTile.y());
/* 255 */       if (f != null)
/* 256 */         f.findableReserveCancel(); 
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\Activity.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */