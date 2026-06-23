/*     */ package world.region.updating;
/*     */ 
/*     */ import java.util.Random;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuilding;
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
/*     */ class BOther
/*     */ {
/*     */   private final Builder.Sort<Integer> tree;
/* 100 */   private double[] prios = new double[256];
/*     */ 
/*     */   
/*     */   BOther(LIST<RDBuilding> all) {
/* 104 */     Random ran = new Random(12345678910L);
/* 105 */     for (int i = 0; i < this.prios.length; i++) {
/* 106 */       this.prios[i] = ran.nextDouble();
/*     */     }
/*     */     
/* 109 */     LinkedList<Builder.RBuilding<Integer>> aa = new LinkedList();
/* 110 */     for (RDBuilding b : all) {
/* 111 */       if (!b.AIBuild)
/*     */         continue; 
/* 113 */       aa.add(new Builder.RBuilding<Integer>(b)
/*     */           {
/*     */             public double value(RealmBuilder current, Region rcurrent)
/*     */             {
/* 117 */               int i = this.bu.index() + RD.RAN().get(rcurrent, 0, 16);
/* 118 */               i &= 0xFF;
/* 119 */               return Builder.BOther.this.prios[i];
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             double value(Integer t, RealmBuilder builder, Region reg) {
/* 125 */               return 0.0D;
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 131 */     this.tree = new Builder.Sort<>((LIST<Builder.RBuilding<Integer>>)aa);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void build(Region reg, RealmBuilder builder) {
/* 137 */     this.tree.build(reg, builder, Builder.points(builder, reg, 1.0D));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\regio\\updating\Builder$BOther.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */