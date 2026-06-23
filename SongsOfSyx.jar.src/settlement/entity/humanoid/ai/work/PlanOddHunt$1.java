/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import settlement.entity.animal.Animal;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
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
/*     */ class null
/*     */   extends PlanOddHunt.HResumer
/*     */ {
/*     */   null(PlanOddHunt paramPlanOddHunt2, AIPLAN.PLANRES $anonymous0) {
/*  61 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/*  66 */     if (e.type == HPoll.SCARE_ANIMAL_NOT)
/*  67 */       return 1.0D; 
/*  68 */     return super.poll(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*  73 */     if (e.event == HEvent.COLLISION_SOFT)
/*     */     {
/*  75 */       if (e.other instanceof Animal) {
/*  76 */         Animal prey = PlanOddHunt.this.getPrey(a, d);
/*  77 */         Animal an = (Animal)e.other;
/*  78 */         if (prey != an && 
/*  79 */           an.huntReservable()) {
/*  80 */           if (prey != null)
/*  81 */             prey.huntReserveCancel(); 
/*  82 */           prey = an;
/*  83 */           prey.huntReserve();
/*  84 */           d.planObject = prey.id();
/*     */         } 
/*     */ 
/*     */         
/*  88 */         if (prey == an) {
/*  89 */           a.speed.magnitudeInit(0.0D);
/*  90 */           AISUB.AISubActivation s = PlanOddHunt.this.drag_back.trySet(a, d);
/*  91 */           if (s != null) {
/*  92 */             d.overwrite(a, s);
/*  93 */             return false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 101 */     return super.event(a, d, e);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 106 */     AISUB.AISubActivation ac = (AI.SUBS()).walkTo.path(a, d);
/* 107 */     if (ac != null)
/* 108 */       return ac; 
/* 109 */     can(a, d);
/* 110 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 116 */     Animal prey = PlanOddHunt.this.getPrey(a, d);
/* 117 */     int dx = prey.physics.tileC().x() - a.physics.tileC().x();
/* 118 */     int dy = prey.physics.tileC().y() - a.physics.tileC().y();
/*     */     
/* 120 */     if (Math.abs(dx) + Math.abs(dy) == 1) {
/* 121 */       return PlanOddHunt.this.drag_back.set(a, d);
/*     */     }
/*     */ 
/*     */     
/* 125 */     AISUB.AISubActivation ac = (AI.SUBS()).walkTo.coo(a, d, prey.physics.tileC());
/* 126 */     if (ac != null)
/* 127 */       return ac; 
/* 128 */     can(a, d);
/* 129 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 135 */     return (PlanOddHunt.this.getPrey(a, d) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 140 */     Animal prey = PlanOddHunt.this.getPrey(a, d);
/* 141 */     if (prey != null)
/* 142 */       prey.huntReserveCancel(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\PlanOddHunt$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */