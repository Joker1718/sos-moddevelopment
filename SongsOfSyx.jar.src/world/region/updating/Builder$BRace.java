/*     */ package world.region.updating;
/*     */ 
/*     */ import game.boosting.BoostSpec;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuilding;
/*     */ import world.region.pop.RDEdicts;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BRace
/*     */ {
/* 239 */   private LinkedList<Builder.RBuilding<RDRace>> all = new LinkedList();
/*     */   
/*     */   private final Builder.Sort<RDRace> tree;
/*     */   
/*     */   BRace() {
/* 244 */     KeyMap<RDRace> map = new KeyMap();
/*     */     
/* 246 */     for (RDRace r : (RD.RACES()).all) {
/* 247 */       map.put(r.pop.dtarget.key, r);
/*     */     }
/*     */     
/* 250 */     for (RDBuilding bu : (RD.BUILDINGS()).all) {
/* 251 */       Builder.RBuilding<RDRace> br = new Builder.RBuilding<RDRace>(bu)
/*     */         {
/*     */           double value(RDRace t, RealmBuilder builder, Region reg) {
/* 254 */             return builder.policy(t.race, reg);
/*     */           }
/*     */         };
/* 257 */       for (BoostSpec s : bu.boosters().all()) {
/* 258 */         if (map.containsKey(s.boostable.key)) {
/* 259 */           br.bos.add(new Builder.RSpec<>(s, (RDRace)map.get(s.boostable.key)));
/*     */         }
/*     */       } 
/* 262 */       if (bu.AIBuild && br.bos.size() > 0) {
/* 263 */         this.all.add(br);
/*     */       }
/*     */     } 
/* 266 */     this.tree = new Builder.Sort<>((LIST<Builder.RBuilding<RDRace>>)this.all);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void build(Region reg, RealmBuilder builder) {
/* 274 */     this.tree.build(reg, builder, Builder.points(builder, reg, 0.75D));
/*     */     
/* 276 */     for (RDRace r : (RD.RACES()).all) {
/* 277 */       double v = builder.policy(r.race, reg);
/* 278 */       for (RDEdicts.RDRaceEdict ee : (RD.RACES()).edicts.all) {
/* 279 */         ee.toggled(r).set(reg, 0);
/*     */       }
/*     */       
/* 282 */       if (v < 0.0D) {
/* 283 */         v = -v;
/* 284 */         int i = (int)Math.round(v * (RD.RACES()).edicts.all.size()) - 1;
/* 285 */         i = CLAMP.i(i, 0, (RD.RACES()).edicts.all.size() - 1);
/* 286 */         if (i >= 0)
/* 287 */           ((RDEdicts.RDRaceEdict)(RD.RACES()).edicts.all.get(i)).toggled(r).set(reg, 1); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\regio\\updating\Builder$BRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */