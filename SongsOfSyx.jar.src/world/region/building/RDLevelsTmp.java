/*    */ package world.region.building;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.faction.FACTIONS;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.Alloc;
/*    */ import view.main.VIEW;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
/*    */ 
/*    */ 
/*    */ public class RDLevelsTmp
/*    */ {
/*    */   Region reg;
/*    */   private final int[] levels;
/* 16 */   int active = 0;
/*    */   
/*    */   private int vi;
/*    */   
/*    */   private int cc;
/*    */   
/*    */   void init(Region reg) {
/* 23 */     this.reg = reg;
/* 24 */     Arrays.fill(this.levels, 0);
/* 25 */     for (int i = 0; i < (RD.BUILDINGS()).all.size(); i++) {
/* 26 */       RDBuilding b = (RDBuilding)(RD.BUILDINGS()).all.get(i);
/* 27 */       this.levels[b.index()] = b.level.get(reg);
/*    */     } 
/*    */   }
/*    */   
/*    */   public int level(RDBuilding bu, Region reg) {
/* 32 */     if (this.active > 0 && reg == this.reg)
/* 33 */       return this.levels[bu.index()]; 
/* 34 */     return bu.level.get(reg);
/*    */   }
/*    */   
/*    */   public void levelSet(RDBuilding bu, int i) {
/* 38 */     this.levels[bu.index()] = i;
/*    */   }
/*    */   
/*    */   public boolean hasChange() {
/* 42 */     for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 43 */       if (this.levels[b.index()] != b.level.get(this.reg))
/* 44 */         return true; 
/*    */     } 
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int cost() {
/* 50 */     if (this.vi == VIEW.RI())
/* 51 */       return this.cc; 
/* 52 */     this.vi = VIEW.RI();
/* 53 */     int am = 0;
/* 54 */     for (RDBuilding b : (RD.BUILDINGS()).all) {
/*    */       
/* 56 */       if (this.levels[b.index()] > b.level.get(this.reg)) {
/* 57 */         am += ((RDBuildingLevel)b.levels.get(this.levels[b.index()])).cost - ((RDBuildingLevel)b.levels.get(b.level.get(this.reg))).cost;
/*    */       }
/*    */     } 
/* 60 */     this.cc = am;
/* 61 */     return this.cc;
/*    */   }
/*    */   
/*    */   public void accept() {
/* 65 */     for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 66 */       b.level.set(this.reg, this.levels[b.index()]);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canAfford() {
/* 73 */     if (cost() > FACTIONS.player().credits().getD())
/* 74 */       return false; 
/* 75 */     for (RDBuildPoints.RDBuildPoint b : (RD.BUILDINGS()).costs.ALL) {
/*    */       
/* 77 */       if (b.bo.get((BOOSTABLE_O)this.reg) < 0.0D) {
/* 78 */         return false;
/*    */       }
/*    */     } 
/* 81 */     return true;
/*    */   }
/*    */   
/*    */   RDLevelsTmp(int am) {
/* 85 */     this.vi = -1;
/*    */     this.levels = Alloc.ii(am);
/*    */   }
/*    */   
/*    */   public CharSequence canAfford(RDBuilding bu, Region reg, int level) {
/* 90 */     int lc = level(bu, reg);
/* 91 */     return bu.canAfford(reg, lc, level);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\RDLevelsTmp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */