/*     */ package settlement.entity.humanoid.ai.consume;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.room.service.module.RoomServiceAccess;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Tree;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlansServices
/*     */ {
/*     */   private final ArrayList<Node> plans;
/*     */   private Tree<Node> sort;
/*     */   
/*     */   PlansServices(SPlanAbs... plans) {
/*  19 */     int am = 0; byte b; int i; SPlanAbs[] arrayOfSPlanAbs;
/*  20 */     for (i = (arrayOfSPlanAbs = plans).length, b = 0; b < i; ) { SPlanAbs<?> p = arrayOfSPlanAbs[b];
/*  21 */       am += p.services.size();
/*     */       b++; }
/*     */     
/*  24 */     this.plans = new ArrayList(am);
/*     */     
/*  26 */     for (i = (arrayOfSPlanAbs = plans).length, b = 0; b < i; ) { SPlanAbs<?> p = arrayOfSPlanAbs[b];
/*  27 */       for (RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER s : p.services) {
/*  28 */         this.plans.add(new Node(p, s.service()));
/*     */       }
/*     */       b++; }
/*     */     
/*  32 */     this.sort = new Tree<Node>(this.plans.size())
/*     */       {
/*     */         protected boolean isGreaterThan(PlansServices.Node current, PlansServices.Node cmp)
/*     */         {
/*  36 */           return (current.v > cmp.v);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean worthTrying(Humanoid a, AIManager d) {
/*  43 */     for (Node n : this.plans) {
/*  44 */       for (RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER s : n.plan.services) {
/*  45 */         RoomServiceAccess b = s.service();
/*  46 */         if (b.accessRequest(a) && b.finder.has(a.tc()))
/*  47 */           return true; 
/*     */       } 
/*     */     } 
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*  56 */     this.sort.clear();
/*  57 */     for (Node n : this.plans) {
/*  58 */       if (n.b.accessRequest(a) && n.b.finder.has(a.tc())) {
/*  59 */         n.v = RND.rFloat() * n.b.usage;
/*  60 */         if (!n.b.stats().access(a)) {
/*  61 */           this.sort.add(n);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  66 */     while (this.sort.hasMore()) {
/*  67 */       Node n = (Node)this.sort.pollGreatest();
/*  68 */       d.planByte3 = (byte)n.b.room().typeIndex();
/*  69 */       AIPLAN.AiPlanActivation p = n.plan.activate(a, d);
/*  70 */       if (p != null) {
/*  71 */         return p;
/*     */       }
/*     */     } 
/*     */     
/*  75 */     for (Node n : this.plans) {
/*  76 */       if (n.b.accessRequest(a) && n.b.finder.has(a.tc()) && 
/*  77 */         n.b.stats().access(a)) {
/*  78 */         this.sort.add(n);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  83 */     while (this.sort.hasMore()) {
/*  84 */       Node n = (Node)this.sort.pollGreatest();
/*  85 */       d.planByte3 = (byte)n.b.room().typeIndex();
/*  86 */       AIPLAN.AiPlanActivation p = n.plan.activate(a, d);
/*  87 */       if (p != null) {
/*  88 */         return p;
/*     */       }
/*     */     } 
/*     */     
/*  92 */     for (Node n : this.plans) {
/*  93 */       n.b.clearAccess(a);
/*     */     }
/*     */     
/*  96 */     return null;
/*     */   }
/*     */   
/*     */   private static class Node
/*     */   {
/*     */     private final SPlanAbs<?> plan;
/*     */     private final RoomServiceAccess b;
/*     */     private double v;
/*     */     
/*     */     Node(SPlanAbs<?> plan, RoomServiceAccess b) {
/* 106 */       this.plan = plan;
/* 107 */       this.b = b;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\PlansServices.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */