/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ final class PlanHangArround
/*     */   extends PlanWork
/*     */ {
/*     */   public PlanHangArround(String key) {
/*  21 */     super(key);
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
/*  57 */     this.stand = new AIPLAN.PLANRES.Resumer(this, ¤¤wait)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  61 */           if (RND.rBoolean())
/*  62 */             return (AI.SUBS()).STAND.activate(a, d, (AI.STATES()).anima.wave.activate(a, d, 2.0D)); 
/*  63 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  68 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  73 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  81 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ¤¤wait)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  85 */           return (AI.SUBS()).walkTo.room(a, d, PlanHangArround.work(a));
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  90 */           return PlanHangArround.this.stand.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  95 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 103 */     this.walkIn = new AIPLAN.PLANRES.Resumer(this, ¤¤wait)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 107 */           RoomInstance r = PlanHangArround.work(a);
/* 108 */           int di = RND.rInt(DIR.ORTHO.size());
/* 109 */           for (int i = 0; i < DIR.ALL.size(); i++) {
/* 110 */             DIR dd = (DIR)DIR.ALL.getC(di + i);
/* 111 */             int dx = a.tc().x() + dd.x();
/* 112 */             int dy = a.tc().y() + dd.y();
/* 113 */             if (r.is(dx, dy)) {
/* 114 */               AVAILABILITY av = (SETT.PATH()).availability.get(dx, dy);
/* 115 */               if (av.player >= 0.0D && av.player < 2.0D && av.from == 0.0D) {
/* 116 */                 return (AI.SUBS()).walkTo.cooFull(a, d, dx, dy);
/*     */               }
/*     */             } 
/*     */           } 
/* 120 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 125 */           return PlanHangArround.this.stand.set(a, d);
/*     */         }
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/* 130 */           return true;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */   
/*     */   private static CharSequence ¤¤wait = "¤Waiting for work";
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 140 */     if (e.type == HPoll.WORKING) {
/* 141 */       return 1.0D;
/*     */     }
/* 143 */     return super.poll(a, d, e);
/*     */   }
/*     */   
/*     */   private final AIPLAN.PLANRES.Resumer stand;
/*     */   private final AIPLAN.PLANRES.Resumer walk;
/*     */   private final AIPLAN.PLANRES.Resumer walkIn;
/*     */   
/*     */   static {
/*     */     D.ts(PlanHangArround.class);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     if (!(SETT.PATH()).reachability.is(work(a).mX(), work(a).mY()))
/*     */       return null; 
/*     */     if (work(a).is(a.physics.tileC())) {
/*     */       if (RND.rInt(25) != 0)
/*     */         return this.stand.set(a, d); 
/*     */       return this.walkIn.set(a, d);
/*     */     } 
/*     */     if (work(a).body().width() <= 1 && work(a).body().height() <= 1 && a.physics.tileC().tileDistanceTo(work(a).mX(), work(a).mY()) < 10.0D) {
/*     */       if (RND.rInt(15) != 0)
/*     */         return this.stand.set(a, d); 
/*     */       return this.walk.set(a, d);
/*     */     } 
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanHangArround.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */