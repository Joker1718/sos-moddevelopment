/*     */ package world.army;
/*     */ 
/*     */ import game.boosting.BUtil;
/*     */ import game.boosting.BoosterAbs;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import world.WORLD;
/*     */ import world.army.ai.WArmyAI;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AD
/*     */   extends WORLD.WorldResource
/*     */ {
/*     */   static AD self;
/*     */   private final ArrayListGrower<BoosterAbs<WArmy>> moraleFactors;
/*     */   private final ADInit init;
/*     */   private final ArrayList<ADArmies> fArmies;
/*     */   private final ADConscripts conscripts;
/*     */   private final ADSoldiers soldiers;
/*     */   private final ADPower power;
/*     */   final ADSupplies supplies;
/*     */   private final INT_O.INT_OE<WArmy> data;
/*     */   private final ADStats stats;
/*     */   private final ADUpdater updater;
/*     */   private final ADUpdaterDiv updaterDiv;
/*     */   public final WArmyAI AI;
/*     */   private final WDivStoredAll divsCity;
/*     */   private final WDivMercenaries divsMerc;
/*     */   private final WDivRegionalAll divsReg;
/*     */   private final INT_O.INT_OE<WArmy> random;
/*     */   private final WORLD.WorldResourceManager saver;
/*     */   
/*     */   public AD(WORLD ww) {
/* 103 */     super("Armies", "AD"); self = this; this.moraleFactors = new ArrayListGrower(); this.init = new ADInit(); this.fArmies = new ArrayList(FACTIONS.MAX() + 1); this.conscripts = new ADConscripts(this.init); this.soldiers = new ADSoldiers(this.init); this.power = new ADPower(this.init); this.supplies = new ADSupplies(this.init); this.init.dataA.getClass(); this.data = (INT_O.INT_OE<WArmy>)new DataO.DataShort(this.init.dataA, "FACTION"); this.stats = new ADStats(this.init); this.updater = new ADUpdater(this.init); this.updaterDiv = new ADUpdaterDiv(this.init); this.AI = new WArmyAI(); this.divsCity = new WDivStoredAll(); this.divsMerc = new WDivMercenaries(); this.divsReg = new WDivRegionalAll(); this.init.dataA.getClass(); this.random = (INT_O.INT_OE<WArmy>)new DataO.DataInt(this.init.dataA, "Random"); this.saver = new WORLD.WorldResourceManager() { public void save(FilePutter file) { for (ADArmies a : AD.this.fArmies) a.saver.save(file);  AD.this.updater.save(file); AD.this.updaterDiv.save(file); AD.this.AI.saver.save(file); AD.this.divsCity.save(file); AD.this.divsMerc.save(file); AD.this.divsReg.save(file); } public void load(FileGetter file) throws IOException { for (ADArmies a : AD.this.fArmies) a.saver.load(file);  AD.this.updater.load(file); AD.this.updaterDiv.load(file); AD.this.AI.saver.load(file); AD.this.divsCity.load(file); AD.this.divsMerc.load(file); AD.this.divsReg.load(file); } public void clear() { for (ADArmies a : AD.this.fArmies) a.saver.clear();  AD.this.updater.clear(); AD.this.updaterDiv.clear(); AD.this.AI.saver.clear(); AD.this.divsReg.clear(); } public void generate(ACTION loadPrint) { for (Faction f : FACTIONS.all()) { if (f.isActive()) { for (ACTION.ACTION_O<Faction> a : AD.this.init.inits) a.exe(f);  AD.this.AI.init(f); }  }  AD.mercenaries().randmoize(); } }
/* 104 */       ; this.fArmies.add(new ADArmies(-1, 1024));
/* 105 */     while (this.fArmies.hasRoom()) {
/* 106 */       this.fArmies.add(new ADArmies(this.fArmies.size() - 1, 60));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public WORLD.WorldResourceManager saver() {
/* 113 */     return this.saver;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler prof) {
/* 118 */     prof.logStart(this);
/*     */     
/* 120 */     this.updater.update(ds);
/* 121 */     this.updaterDiv.update(ds);
/* 122 */     this.divsCity.update(ds);
/* 123 */     this.divsMerc.update(ds);
/* 124 */     this.AI.update(ds);
/* 125 */     prof.logEnd(this);
/*     */   }
/*     */   
/*     */   static ADInit iinit() {
/* 129 */     return self.init;
/*     */   }
/*     */   
/*     */   public static ADArmies army(Faction f) {
/* 133 */     return (ADArmies)self.fArmies.get((f == null) ? 0 : (f.index() + 1));
/*     */   }
/*     */   
/*     */   public static ADConscripts conscripts() {
/* 137 */     return self.conscripts;
/*     */   }
/*     */   
/*     */   public static Faction faction(WArmy a) {
/* 141 */     if (self.data.get(a) == 0)
/* 142 */       return null; 
/* 143 */     return FACTIONS.getByIndex(self.data.get(a) - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void factionSet(WArmy a, Faction f) {
/* 149 */     if (faction(a) == f) {
/*     */       return;
/*     */     }
/* 152 */     removeOnlyTobeCalledFromAnArmy(a);
/*     */ 
/*     */ 
/*     */     
/* 156 */     addOnlyToBeCalledFromAnArmy(a, f);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addOnlyToBeCalledFromAnArmy(WArmy a, Faction f) {
/* 161 */     self.data.set(a, (f == null) ? 0 : (f.index() + 1));
/* 162 */     ADArmies aa = army(faction(a));
/* 163 */     aa.armies.add(a.armyIndex());
/* 164 */     for (ADInit.Countable cc : self.init.countable) {
/* 165 */       cc.count(a, 1);
/*     */     }
/* 167 */     self.random.set(a, RND.rInt() & Integer.MAX_VALUE);
/*     */   }
/*     */   
/*     */   public static void removeOnlyTobeCalledFromAnArmy(WArmy a) {
/* 171 */     for (ADInit.Countable cc : self.init.countable) {
/* 172 */       cc.count(a, -1);
/*     */     }
/* 174 */     ADArmies aa = army(faction(a));
/* 175 */     aa.armies.removeShort(a.armyIndex());
/*     */   }
/*     */   
/*     */   public static ADInt men(Race race) {
/* 179 */     return self.soldiers.current(race);
/*     */   }
/*     */   
/*     */   public static ADInt menTarget(Race race) {
/* 183 */     return self.soldiers.target(race);
/*     */   }
/*     */   
/*     */   public static void updateArmy(WArmy a) {
/* 187 */     self.AI.update(a);
/*     */   }
/*     */   
/*     */   static void register(ADDiv div, int d) {
/* 191 */     if (div.army() == null) {
/*     */       return;
/*     */     }
/* 194 */     for (ADInit.Register rr : self.init.registers) {
/* 195 */       rr.register(div, d);
/*     */     }
/*     */   }
/*     */   
/*     */   public static ADPower power() {
/* 200 */     return self.power;
/*     */   }
/*     */   
/*     */   public static ADStats stats() {
/* 204 */     return self.stats;
/*     */   }
/*     */   
/*     */   public static ADSupplies supplies() {
/* 208 */     return self.supplies;
/*     */   }
/*     */   
/*     */   public static WDivStoredAll cityDivs() {
/* 212 */     return self.divsCity;
/*     */   }
/*     */   
/*     */   public static WDivRegionalAll regional() {
/* 216 */     return self.divsReg;
/*     */   }
/*     */   
/*     */   public static WDivMercenaries mercenaries() {
/* 220 */     return self.divsMerc;
/*     */   }
/*     */   
/*     */   public static ArrayListGrower<BoosterAbs<WArmy>> moraleFactors() {
/* 224 */     return self.moraleFactors;
/*     */   }
/*     */   
/*     */   public static double morale(WArmy a) {
/* 228 */     return BUtil.value((LIST)self.moraleFactors, a);
/*     */   }
/*     */   
/*     */   public static double rnd(WArmy a) {
/* 232 */     return self.random.getD(a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\AD.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */