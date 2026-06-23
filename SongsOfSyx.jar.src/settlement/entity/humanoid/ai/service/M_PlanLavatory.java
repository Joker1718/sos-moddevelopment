/*     */ package settlement.entity.humanoid.ai.service;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.service.lavatory.Lavatory;
/*     */ import settlement.room.service.lavatory.LavatoryInstance;
/*     */ import settlement.room.service.lavatory.ROOM_LAVATORY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ class M_PlanLavatory extends MPlan<ROOM_LAVATORY> {
/*     */   private final AIPLAN.PLANRES.Resumer takingDump;
/*     */   
/*     */   public M_PlanLavatory() {
/*  20 */     super("Lav", (SETT.ROOMS()).LAVATORIES, true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  28 */     this.takingDump = new AIPLAN.PLANRES.Resumer(this, "PlanDischarging")
/*     */       {
/*  30 */         private final AISUB sub = (AISUB)new AISUB.Simple("taking a dump")
/*     */           {
/*     */             protected AISTATE resume(Humanoid a, AIManager d) {
/*  33 */               d.subByte = (byte)(d.subByte + 1);
/*     */               
/*  35 */               if (d.subByte > 4 + RND.rInt(5)) {
/*  36 */                 return null;
/*     */               }
/*  38 */               if ((M_PlanLavatory.null.access$0(M_PlanLavatory.null.this).blue(d).service()).usageSound != null && RND.oneIn(2)) {
/*  39 */                 (M_PlanLavatory.null.access$0(M_PlanLavatory.null.this).blue(d).service()).usageSound.rnd(a);
/*     */               }
/*  41 */               return (AI.STATES()).STAND.activate(a, d, 5.0D);
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  47 */           Lavatory l = M_PlanLavatory.this.get(a, d);
/*  48 */           a.speed.setDirCurrent(l.getDir());
/*  49 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  54 */           M_PlanLavatory.this.get(a, d).consume();
/*  55 */           return M_PlanLavatory.this.walk2Water.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  60 */           Lavatory lavatory = M_PlanLavatory.this.get(a, d);
/*  61 */           return (lavatory != null && lavatory.findableReservedIs());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  66 */           Lavatory lavatory = M_PlanLavatory.this.get(a, d);
/*  67 */           if (lavatory != null) {
/*  68 */             lavatory.findableReserveCancel();
/*     */           }
/*     */         }
/*     */       };
/*  72 */     this.walk2Water = new AIPLAN.PLANRES.Resumer(this, "Washing up")
/*     */       {
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  78 */           LavatoryInstance b = (LavatoryInstance)M_PlanLavatory.this.blue(d).get(a.physics.tileC().x(), a.physics.tileC().y());
/*  79 */           if (b != null) {
/*  80 */             COORDINATE c = b.getExtra();
/*     */             
/*  82 */             if (c != null) {
/*  83 */               AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, c);
/*  84 */               if (s == null) {
/*  85 */                 can(a, d);
/*  86 */                 return null;
/*     */               } 
/*  88 */               return s;
/*     */             } 
/*     */           } 
/*  91 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  96 */           return M_PlanLavatory.this.washing.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 101 */           return M_PlanLavatory.this.blue(d).isExtra(d.path.destX(), d.path.destY());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 106 */           if (M_PlanLavatory.this.blue(d).isExtra(d.path.destX(), d.path.destY())) {
/* 107 */             LavatoryInstance b = (LavatoryInstance)M_PlanLavatory.this.blue(d).get(d.path.destX(), d.path.destY());
/* 108 */             b.returnExtra(d.path.destX(), d.path.destY());
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 113 */     this.washing = new AIPLAN.PLANRES.Resumer(this, "Washing up")
/*     */       {
/* 115 */         private final AISUB sub = (AISUB)new AISUB.Simple("washing")
/*     */           {
/*     */             protected AISTATE resume(Humanoid a, AIManager d) {
/* 118 */               d.subByte = (byte)(d.subByte + 1);
/*     */               
/* 120 */               if (d.subByte > 1) {
/* 121 */                 return null;
/*     */               }
/* 123 */               return (AI.STATES()).anima.box.activate(a, d, 15.0D);
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 129 */           return this.sub.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 134 */           can(a, d);
/* 135 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 140 */           return M_PlanLavatory.this.blue(d).isExtra(d.path.destX(), d.path.destY());
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 145 */           if (M_PlanLavatory.this.blue(d).isExtra(d.path.destX(), d.path.destY())) {
/* 146 */             LavatoryInstance b = (LavatoryInstance)M_PlanLavatory.this.blue(d).get(d.path.destX(), d.path.destY());
/* 147 */             b.returnExtra(d.path.destX(), d.path.destY());
/*     */           } 
/*     */         }
/*     */       };
/*     */   } private final AIPLAN.PLANRES.Resumer walk2Water; private final AIPLAN.PLANRES.Resumer washing;
/*     */   
/*     */   protected Lavatory get(Humanoid a, AIManager d) {
/* 154 */     return blue(d).getService(d.planTile.x(), d.planTile.y());
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation arrive(Humanoid a, AIManager d) {
/*     */     return this.takingDump.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\M_PlanLavatory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */