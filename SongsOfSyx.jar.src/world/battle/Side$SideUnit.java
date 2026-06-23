/*     */ package world.battle;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.WDIV;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SideUnit
/*     */ {
/*     */   private int type;
/*     */   private static final int T_ARMY = 0;
/*     */   private static final int T_GARRISON = 1;
/*     */   private int regionI;
/*     */   private int armyI;
/*     */   private int maxDivs;
/*     */   
/*     */   void copy(SideUnit o) {
/* 150 */     this.type = o.type;
/* 151 */     this.regionI = o.regionI;
/* 152 */     this.armyI = o.armyI;
/* 153 */     this.maxDivs = o.maxDivs;
/*     */   }
/*     */   
/*     */   public SideUnit set(Region reg, int maxDivs) {
/* 157 */     this.type = 1;
/* 158 */     this.regionI = reg.index();
/* 159 */     this.maxDivs = maxDivs;
/* 160 */     return this;
/*     */   }
/*     */   
/*     */   public SideUnit set(WArmy a, int maxDivs) {
/* 164 */     this.type = 0;
/* 165 */     this.armyI = a.armyIndex();
/* 166 */     this.maxDivs = maxDivs;
/* 167 */     return this;
/*     */   }
/*     */   
/*     */   public int divs() {
/* 171 */     switch (this.type) { case 0:
/* 172 */         return CLAMP.i(a().divs().size(), 0, this.maxDivs);
/* 173 */       case 1: return CLAMP.i(RD.MILITARY().divisions(r()).size(), 0, this.maxDivs); }
/* 174 */      throw new RuntimeException();
/*     */   }
/*     */ 
/*     */   
/*     */   public WDIV div(int index) {
/* 179 */     switch (this.type) { case 0:
/* 180 */         return (WDIV)a().divs().get(index);
/* 181 */       case 1: return (WDIV)RD.MILITARY().divisions(r()).get(index); }
/* 182 */      throw new RuntimeException();
/*     */   }
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 187 */     switch (this.type) { case 0:
/* 188 */         return a().faction();
/* 189 */       case 1: return r().faction(); }
/* 190 */      throw new RuntimeException();
/*     */   }
/*     */ 
/*     */   
/*     */   public double power() {
/* 195 */     switch (this.type) { case 0:
/* 196 */         return ((a().faction() == FACTIONS.player()) ? 0.8D : 1.0D) * AD.power().get(a());
/* 197 */       case 1: return ((r().faction() == FACTIONS.player()) ? 0.8D : 1.0D) * (RD.MILITARY()).power.getD(r()); }
/* 198 */      throw new RuntimeException();
/*     */   }
/*     */ 
/*     */   
/*     */   public int x() {
/* 203 */     switch (this.type) { case 0:
/* 204 */         return a().ctx();
/* 205 */       case 1: return r().cx(); }
/* 206 */      throw new RuntimeException();
/*     */   }
/*     */ 
/*     */   
/*     */   public int y() {
/* 211 */     switch (this.type) { case 0:
/* 212 */         return a().cty();
/* 213 */       case 1: return r().cy(); }
/* 214 */      throw new RuntimeException();
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/* 219 */     switch (this.type) { case 0:
/* 220 */         return AD.men(null).get(a());
/* 221 */       case 1: return (RD.MILITARY()).garrison.get(r()); }
/* 222 */      throw new RuntimeException();
/*     */   }
/*     */ 
/*     */   
/*     */   public WArmy a() {
/* 227 */     if (this.type == 0)
/* 228 */       return (WORLD.ENTITIES()).armies.get(this.armyI); 
/* 229 */     return null;
/*     */   }
/*     */   
/*     */   public Region r() {
/* 233 */     if (this.type == 1)
/* 234 */       return WORLD.REGIONS().getByIndex(this.regionI); 
/* 235 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isSameAs(SideUnit o) {
/* 239 */     if (this.type == o.type)
/* 240 */       return !((this.type != 1 || this.regionI != o.regionI) && (this.type != 0 || this.armyI != o.armyI)); 
/* 241 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Side$SideUnit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */