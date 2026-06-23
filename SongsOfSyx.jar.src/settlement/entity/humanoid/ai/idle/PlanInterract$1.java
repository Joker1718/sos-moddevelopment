/*     */ package settlement.entity.humanoid.ai.idle;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
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
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer wait;
/*     */   private final AIPLAN.PLANRES.Resumer walking;
/*     */   private final AIPLAN.PLANRES.Resumer first;
/*     */   
/*     */   null(String $anonymous0) {
/*  51 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  61 */     this.wait = new AIPLAN.PLANRES.Resumer(this, PlanInterract.¤¤hanging)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  66 */           d.planByte1 = (byte)(10 + RND.rInt(10));
/*     */           
/*  68 */           if ((SETT.PATH()).finders.getOutofWay.shouldFind((ENTITY)a)) {
/*  69 */             (SETT.PATH()).finders.getOutofWay.request(a, d.path);
/*  70 */             return PlanInterract.null.this.walking.set(a, d);
/*     */           } 
/*     */           
/*  73 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  78 */           d.planByte1 = (byte)(d.planByte1 - 1); if (AIModules.current(d).moduleCanContinue(a, d) && d.planByte1 > 0) {
/*  79 */             (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */           }
/*  81 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  86 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/*  96 */           if (e.type == HPoll.CAN_INTERRACT && a.speed.isZero())
/*  97 */             return 1.0D; 
/*  98 */           return super.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 102 */     this.walking = new AIPLAN.PLANRES.Resumer(this, PlanInterract.¤¤hanging)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 106 */           return (AI.SUBS()).STAND.activateRndDir(a, d, 1 + RND.rInt(4));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 111 */           d.planByte1 = (byte)(d.planByte1 - 1); if (AIModules.current(d).moduleCanContinue(a, d) && d.planByte1 > 0) {
/* 112 */             (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */           }
/* 114 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 119 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 129 */           if (e.type == HPoll.CAN_INTERRACT && a.speed.isZero())
/* 130 */             return 1.0D; 
/* 131 */           return super.poll(a, d, e);
/*     */         }
/*     */       };
/*     */     
/* 135 */     this.first = new AIPLAN.PLANRES.Resumer(this, "")
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 139 */           d.otherEntitySet(null);
/* 140 */           Humanoid o = PlanInterract.null.this.findAndSet(a);
/* 141 */           if (o == null)
/* 142 */             return null; 
/* 143 */           if (!d.path.request(a.tc(), o.tc().x(), o.tc().y())) {
/* 144 */             return null;
/*     */           }
/* 146 */           d.otherEntitySet(o);
/* 147 */           return (AI.SUBS()).walkTo.path(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 152 */           if (PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d) != null && a.tc().tileDistanceTo(PlanInterract.null.access$0(PlanInterract.null.this).friend(a, d).tc()) < 3.0D)
/* 153 */             return d.resumeOtherPlan(a, (PlanInterract.null.access$0(PlanInterract.null.this)).interract); 
/* 154 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 159 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */ 
/*     */         
/*     */         protected void name(Humanoid a, AIManager d, Str string)
/*     */         {
/* 169 */           Humanoid o = d.otherEntity();
/* 170 */           if (o == null) {
/* 171 */             string.add(PlanInterract.¤¤hanging);
/*     */           } else {
/* 173 */             string.add(PlanInterract.¤¤nameMeet).insert(0, STATS.APPEARANCE().name(o.indu()));
/*     */           } 
/*     */         }
/*     */       };
/*     */   } private Humanoid findAndSet(Humanoid a) {
/* 178 */     SComponent c = (SETT.PATH().finders()).otherHumanoid.findComp(a, 20);
/* 179 */     if (c == null) {
/* 180 */       return null;
/*     */     }
/* 182 */     int dim = c.level().size() + 2;
/* 183 */     int x1 = (c.centreX() & (c.level().size() - 1 ^ 0xFFFFFFFF)) - 1;
/* 184 */     int y1 = (c.centreY() & (c.level().size() - 1 ^ 0xFFFFFFFF)) - 1;
/* 185 */     int x2 = x1 + dim;
/* 186 */     int y2 = y1 + dim;
/*     */     
/* 188 */     int rx = x1 + RND.rInt(dim);
/* 189 */     int ry = y1 + RND.rInt(dim);
/* 190 */     Humanoid backup = null;
/*     */ 
/*     */ 
/*     */     
/* 194 */     for (int y = 0; y < dim; y++) {
/* 195 */       for (int x = 0; x < dim; x++) {
/*     */         
/* 197 */         for (ENTITY e : SETT.ENTITIES().getAtTile(rx, ry)) {
/* 198 */           if (e != a && e instanceof Humanoid) {
/* 199 */             Humanoid o = (Humanoid)e;
/*     */             
/* 201 */             if (HEvent.Handler.interract(o, a)) {
/* 202 */               if (o.race() == a.race())
/* 203 */                 return o; 
/* 204 */               if (backup == null) {
/* 205 */                 backup = o;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/* 210 */         rx++;
/* 211 */         if (rx >= x2) {
/* 212 */           rx = x1;
/* 213 */           ry++;
/* 214 */           if (ry >= y2) {
/* 215 */             ry = y1;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 222 */     if (backup != null && 
/* 223 */       PlanInterract.this.shouldFight(a, backup)) {
/* 224 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 229 */     return backup;
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     AISUB.AISubActivation s = this.first.set(a, d);
/*     */     if (s != null)
/*     */       return s; 
/*     */     return this.wait.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\PlanInterract$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */