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
/*     */ class BMil
/*     */ {
/*     */   private final Builder.Sort<Integer> tree;
/* 145 */   private double[] prios = new double[256];
/* 146 */   private LinkedList<Builder.RBuilding<Integer>> all = new LinkedList();
/*     */ 
/*     */   
/*     */   BMil() {
/* 150 */     Random ran = new Random(12345678910L);
/* 151 */     for (int i = 0; i < this.prios.length; i++) {
/* 152 */       this.prios[i] = ran.nextDouble();
/*     */     }
/*     */ 
/*     */     
/* 156 */     for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 157 */       double v = Math.max(b.boosters().max((RD.MILITARY()).bgarrison), b.boosters().max((RD.MILITARY()).bFortification));
/* 158 */       if (!b.AIBuild || v <= 0.0D) {
/*     */         continue;
/*     */       }
/* 161 */       this.all.add(new Builder.RBuilding<Integer>(b)
/*     */           {
/*     */             public double value(RealmBuilder current, Region rcurrent)
/*     */             {
/* 165 */               int i = this.bu.index() + RD.RAN().get(rcurrent, 0, 16);
/* 166 */               i &= 0xFF;
/* 167 */               return Builder.BMil.this.prios[i] * current.military(rcurrent);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             double value(Integer t, RealmBuilder builder, Region reg) {
/* 173 */               return 0.0D;
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 179 */     this.tree = new Builder.Sort<>((LIST<Builder.RBuilding<Integer>>)this.all);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void build(Region reg, RealmBuilder builder) {
/* 185 */     this.tree.build(reg, builder, Builder.points(builder, reg, 1.0D));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\regio\\updating\Builder$BMil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */