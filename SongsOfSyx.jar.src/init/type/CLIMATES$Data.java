/*     */ package init.type;
/*     */ 
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.faction.Faction;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.info.INFO;
/*     */ import util.keymap.RMAP;
/*     */ import util.text.D;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Data
/*     */ {
/*     */   private final CLIMATE COLD;
/*     */   private final CLIMATE TEMPERATE;
/*     */   private final CLIMATE HOT;
/* 114 */   private final ArrayList<CLIMATE> all = new ArrayList(3);
/*     */   private final INFO info;
/*     */   private final BoostSpecs boosters;
/* 117 */   private final KeyMap<CLIMATES.BV> bvmap = new KeyMap();
/*     */   private final RMAP<CLIMATE> map;
/*     */   
/*     */   Data() throws IOException {
/* 121 */     D.gInit(CLIMATES.class);
/* 122 */     this.info = new INFO(D.g("Climate"), D.g("desc", "Climate zones have a range of bonuses and drawbacks. They also have different base temperatures, which can lead to exposure and death for your subjects depending on their natural resilience to hot and cold."));
/* 123 */     CLIMATES.d = this;
/* 124 */     Json j = new Json((PATHS.CONFIG()).init.gets("CLIMATE"));
/* 125 */     this.COLD = new CLIMATE(
/* 126 */         (LISTE<CLIMATE>)this.all, "COLD", 
/* 127 */         D.g("Cold"), 
/* 128 */         D.g("cold_desc", "Very cold winters. Unique crops. Low disease rates."), 
/* 129 */         j);
/* 130 */     this.TEMPERATE = new CLIMATE(
/* 131 */         (LISTE<CLIMATE>)this.all, "TEMPERATE", 
/* 132 */         D.g("Temperate"), 
/* 133 */         D.g("temp_desc", "Varying temperature."), 
/* 134 */         j);
/* 135 */     this.HOT = new CLIMATE(
/* 136 */         (LISTE<CLIMATE>)this.all, "HOT", 
/* 137 */         D.g("Warm"), 
/* 138 */         D.g("warm_desc", "Hot summers."), 
/* 139 */         j);
/*     */     
/* 141 */     this.map = new RMAP("CLIMATE", (LIST)this.all);
/*     */     
/* 143 */     this.boosters = new BoostSpecs(this.info.name, (SPRITE)(UI.icons()).s.heat, true);
/*     */     
/* 145 */     ACTION a = new ACTION()
/*     */       {
/*     */         
/*     */         public void exe()
/*     */         {
/* 150 */           for (CLIMATE c : CLIMATES.ALL()) {
/*     */             
/* 152 */             for (BoostSpec s : c.boosters.all()) {
/* 153 */               String k = s.boostable.key + s.boostable.key;
/* 154 */               if (!CLIMATES.Data.this.bvmap.containsKey(k)) {
/* 155 */                 CLIMATES.Data.this.bvmap.put(k, new CLIMATES.BV(CLIMATES.Data.this.boosters, s.boostable, s.booster.isMul));
/*     */               }
/* 157 */               ((CLIMATES.BV)CLIMATES.Data.this.bvmap.get(k)).set(c, s.booster.to());
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 163 */     BOOSTING.connecter(a);
/*     */     
/* 165 */     for (CLIMATE c : this.all) {
/* 166 */       GVALUES.FACTION.push("CLIMATE_" + c.key, String.valueOf(this.info.name) + ": " + String.valueOf(this.info.name), (SPRITE)(UI.icons()).s.heat, new BOOLEANO<Faction>()
/*     */           {
/*     */             public boolean is(Faction t)
/*     */             {
/* 170 */               if (t.capitolRegion() != null)
/* 171 */                 return ((WORLD.CLIMATE()).getter.get(t.capitolRegion().cx(), t.capitolRegion().cy()) == c); 
/* 172 */               return false;
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CLIMATES$Data.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */