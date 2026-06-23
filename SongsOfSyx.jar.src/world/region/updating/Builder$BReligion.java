/*     */ package world.region.updating;
/*     */ 
/*     */ import game.boosting.BoostSpec;
/*     */ import init.religion.Religion;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.RDReligions;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BReligion
/*     */ {
/* 198 */   private LinkedList<Builder.RBuilding<Religion>> all = new LinkedList();
/*     */   
/*     */   private final Builder.Sort<Religion> tree;
/*     */   
/*     */   BReligion() {
/* 203 */     KeyMap<Religion> boosts = new KeyMap();
/* 204 */     for (RDReligions.RDReligion rr : RD.RELIGION().all()) {
/* 205 */       boosts.put(rr.boost.key, rr.religion);
/*     */     }
/*     */     
/* 208 */     for (RDBuilding bu : (RD.BUILDINGS()).all) {
/* 209 */       Builder.RBuilding<Religion> br = new Builder.RBuilding<Religion>(bu)
/*     */         {
/*     */           double value(Religion t, RealmBuilder builder, Region reg) {
/* 212 */             return builder.priority(t, reg);
/*     */           }
/*     */         };
/*     */       
/* 216 */       for (BoostSpec s : bu.boosters().all()) {
/*     */         
/* 218 */         if (boosts.containsKey(s.boostable.key)) {
/* 219 */           br.bos.add(new Builder.RSpec<>(s, (Religion)boosts.get(s.boostable.key)));
/*     */         }
/*     */       } 
/* 222 */       if (bu.AIBuild && br.bos.size() > 0) {
/* 223 */         this.all.add(br);
/*     */       }
/*     */     } 
/* 226 */     this.tree = new Builder.Sort<>((LIST<Builder.RBuilding<Religion>>)this.all);
/*     */   }
/*     */   
/*     */   void build(Region reg, RealmBuilder builder) {
/* 230 */     this.tree.build(reg, builder, Builder.points(builder, reg, 1.0D));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\regio\\updating\Builder$BReligion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */