/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.type.NEED;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.service.module.ROOM_SPECTATOR;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import settlement.room.service.module.RoomServiceNeed;
/*     */ import settlement.stats.service.StatService;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ class S_Plans {
/*  21 */   private final double[] usageI = new double[NEEDS.ALL().size()];
/*     */   
/*  23 */   public final ArrayListGrower<S_Plan> all = new ArrayListGrower();
/*  24 */   public final ArrayList<ArrayListGrower<S_Plan>> needMap = new ArrayList(NEEDS.ALL().size());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public S_Plans() {
/*  30 */     while (this.needMap.hasRoom()) {
/*  31 */       this.needMap.add(new ArrayListGrower());
/*     */     }
/*  33 */     add(new M_PlanBarber());
/*  34 */     add(new M_PlanBath());
/*  35 */     add(new M_PlanBrothel());
/*  36 */     add(new M_PlanHearth());
/*  37 */     add(new M_PlanLavatory());
/*  38 */     add(new M_PlanPhysician());
/*  39 */     add(new M_PlanWell());
/*  40 */     add(new M_PlanCourt());
/*     */     
/*  42 */     add(new M_PlanSpectator("speak", (SETT.ROOMS()).SPEAKERS));
/*  43 */     add(new M_PlanSpectator("stock", (LIST<? extends ROOM_SPECTATOR.ROOM_SPECTATOR_HASER>)new ArrayList((SETT.ROOMS()).STOCKS)));
/*  44 */     add(new M_PlanSpectator("stage", (SETT.ROOMS()).STAGES));
/*  45 */     add(new M_PlanSpectator("arena", (SETT.ROOMS()).FIGHTPITS));
/*  46 */     add(new M_PlanSpectator("garena", (SETT.ROOMS()).GARENAS));
/*     */ 
/*     */     
/*  49 */     add(new S_PlanShrine());
/*  50 */     add(new S_PlanTemple());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     add(new PlanSkinny());
/*     */ 
/*     */     
/*  58 */     for (int i = 0; i < this.usageI.length; i++) {
/*  59 */       if (this.usageI[i] > 0.0D) {
/*  60 */         this.usageI[i] = 1.0D / this.usageI[i];
/*     */       }
/*     */     } 
/*  63 */     for (NEED n : NEEDS.ALL()) {
/*  64 */       if (n instanceof init.type.NEED_E)
/*     */         continue; 
/*  66 */       if (((ArrayListGrower)this.needMap.get(n.index())).size() == 0) {
/*  67 */         LOG.err(n.key);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void add(final MPlan<? extends RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER> plan) {
/*  76 */     for (RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER ss : plan.services) {
/*  77 */       final RoomServiceAccess n = ss.service();
/*  78 */       S_Plan p = new S_Plan((StatService)n.stats(), n.usage)
/*     */         {
/*     */           public boolean hasAccess(Humanoid a, AIManager d)
/*     */           {
/*  82 */             return (n.stats().access().indu().get(a.indu()) > 0);
/*     */           }
/*     */ 
/*     */           
/*     */           public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*  87 */             return getPlan(a, d, n.radius());
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean allowed(Humanoid a, AIManager d) {
/*  92 */             return (n.stats().accessRequest(a) && n.finder.has(a.tc()));
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean goodTime(Humanoid a, AIManager d) {
/*  97 */             return n.isGoodTime();
/*     */           }
/*     */ 
/*     */           
/*     */           public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d, int dist) {
/* 102 */             if (n.stats().accessRequest(a) && n.finder.has(a.tc())) {
/* 103 */               d.planByte3 = (byte)n.room().typeIndex();
/* 104 */               MPlan.dist = dist;
/* 105 */               AIPLAN.AiPlanActivation p = plan.activate(a, d);
/* 106 */               if (p != null)
/* 107 */                 return p; 
/*     */             } 
/* 109 */             n.clearAccess(a);
/* 110 */             return null;
/*     */           }
/*     */         };
/*     */       
/* 114 */       add(p);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void add(M_PlanSpectator plan) {
/* 119 */     for (ROOM_SPECTATOR.ROOM_SPECTATOR_HASER s : plan.services) {
/* 120 */       add(new S_PlanEntertain((s.service()).need, (RoomServiceNeed.ROOM_SERVICE_NEED_HASER)s, plan));
/*     */     }
/*     */   }
/*     */   
/*     */   private S_Plan add(S_Plan p) {
/* 125 */     this.usageI[p.need.index()] = this.usageI[p.need.index()] + p.usage;
/* 126 */     ((ArrayListGrower)this.needMap.get(p.need.index())).add(p);
/* 127 */     this.all.add(p);
/* 128 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/* 134 */     double lacksAccessTot = 0.0D;
/* 135 */     double allTot = 0.0D;
/*     */     
/* 137 */     for (S_Plan p : this.all) {
/* 138 */       if (!p.allowed(a, d)) {
/* 139 */         p.service.clearAccess(a.indu());
/*     */         
/*     */         continue;
/*     */       } 
/* 143 */       double v = p.need.rate.get((BOOSTABLE_O)a.indu()) * this.usageI[p.need.index()];
/* 144 */       if (p.goodTime(a, d) && !p.hasAccess(a, d)) {
/* 145 */         lacksAccessTot += v;
/*     */       }
/* 147 */       allTot += v;
/*     */     } 
/*     */     
/* 150 */     if (lacksAccessTot > 0.0D) {
/* 151 */       lacksAccessTot = RND.rFloat() * lacksAccessTot;
/* 152 */       for (S_Plan p : this.all) {
/*     */         
/* 154 */         if (p.allowed(a, d) && p.goodTime(a, d) && !p.hasAccess(a, d)) {
/* 155 */           double v = p.need.rate.get((BOOSTABLE_O)a.indu()) * this.usageI[p.need.index()];
/* 156 */           lacksAccessTot -= v;
/* 157 */           if (lacksAccessTot <= 0.0D) {
/* 158 */             AIPLAN.AiPlanActivation pp = p.getPlan(a, d);
/* 159 */             if (pp != null)
/* 160 */               return pp; 
/* 161 */             p.service.clearAccess(a.indu());
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 169 */     allTot = RND.rFloat() * allTot;
/* 170 */     for (S_Plan p : this.all) {
/* 171 */       if (p.allowed(a, d) && p.goodTime(a, d)) {
/* 172 */         double v = p.need.rate.get((BOOSTABLE_O)a.indu()) * this.usageI[p.need.index()];
/* 173 */         allTot -= v;
/* 174 */         if (allTot <= 0.0D) {
/* 175 */           AIPLAN.AiPlanActivation pp = p.getPlan(a, d);
/* 176 */           if (pp == null)
/* 177 */             p.service.clearAccess(a.indu()); 
/* 178 */           return pp;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 186 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\S_Plans.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */