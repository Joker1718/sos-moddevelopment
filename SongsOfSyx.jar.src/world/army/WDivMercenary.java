/*     */ package world.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.util.DIV_SETTING;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.battle.util.DivType;
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResSupply;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import world.entity.army.WArmy;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public final class WDivMercenary
/*     */   extends ADDiv {
/*     */   static final int type = 2;
/*  34 */   private static final COLOR col = (COLOR)COLOR.ORANGE100.makeSaturated(0.5D).shade(0.75D);
/*  35 */   private byte race = 0;
/*     */   private short men;
/*     */   private short menTarget;
/*  38 */   private final DIV_SETTING.DIV_SETTINGImp spec = new DIV_SETTING.DIV_SETTINGImp();
/*     */   private float exp;
/*     */   private int costPerMan;
/*     */   private short nameI;
/*     */   private short bannerI;
/*     */   private Induvidual indu;
/*  44 */   float disbandTime = 0.0F;
/*     */   byte missedPayments;
/*     */   
/*     */   WDivMercenary(int index) {
/*  48 */     super(index);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 279 */     this.target = new DIV_SETTING()
/*     */       {
/*     */         public double training(StatsBattle.StatTraining tr)
/*     */         {
/* 283 */           return WDivMercenary.this.training(tr);
/*     */         }
/*     */ 
/*     */         
/*     */         public int men() {
/* 288 */           return WDivMercenary.this.menTarget;
/*     */         }
/*     */         
/*     */         public double equip(EquipBattle e)
/*     */         {
/* 293 */           return WDivMercenary.this.equip(e);
/*     */         }
/*     */       };
/*     */   }
/*     */   private final DIV_SETTING target;
/*     */   
/*     */   public DIV_SETTING target() {
/* 300 */     return this.target;
/*     */   }
/*     */   
/*     */   void randomize() {
/*     */     report(-1);
/*     */     this.race = (byte)((Race)RACES.all().rnd()).index;
/*     */     double am = 0.0D;
/*     */     for (RDRace r : (RD.RACES()).all)
/*     */       am += (0.1D + r.race.physics.raiding) * r.pop.faction().get(FACTIONS.player()) + 1.0D; 
/*     */     double ri = RND.rFloat() * am;
/*     */     for (RDRace r : (RD.RACES()).all) {
/*     */       ri -= (0.1D + r.race.physics.raiding) * r.pop.faction().get(FACTIONS.player()) + 1.0D;
/*     */       if (ri <= 0.0D) {
/*     */         this.race = (byte)r.race.index;
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     int dmen = 15;
/*     */     int ma = (int)Math.ceil((Config.battle()).MEN_PER_DIVISION / dmen);
/*     */     this.men = (short)CLAMP.i(dmen * RND.rInt(ma), dmen, (Config.battle()).MEN_PER_DIVISION);
/*     */     this.menTarget = this.men;
/*     */     this.exp = (float)CLAMP.d(Math.pow(RND.rFloat(), 1.5D), 0.0D, 1.0D);
/*     */     this.nameI = (short)RND.rInt((race()).info.armyNames.size());
/*     */     DivType type = (GAME.battle()).types.rnd(race(), null, RND.rFloat());
/*     */     this.spec.copySettings((DIV_SETTING)type, this.menTarget, 0.5D + 0.5D * RND.rFloat(), 0.1D + 0.9D * RND.rFloat());
/*     */     bannerSet(RND.rShort());
/*     */     double costBase = ((race()).physics.adultDay * FACTIONS.PRICE().edible());
/*     */     for (StatsBattle.StatTraining t : (STATS.BATTLE()).TRAINING_ALL)
/*     */       costBase += (t.room.TRAINING_DAYS * FACTIONS.PRICE().edible()) * this.spec.training(t); 
/*     */     costBase *= 0.1D;
/*     */     costBase *= 0.5D + this.exp;
/*     */     double costEquip = 0.0D;
/*     */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL())
/*     */       costEquip += e.wearRate() / 16.0D * this.spec.equipI(e) * FACTIONS.PRICE().get((TRADABLE)TR.get(e.resource)); 
/*     */     double cost = costBase + costEquip;
/*     */     for (ResSupply s : (RESOURCES.SUP()).ALL)
/*     */       cost += 1.25D * FACTIONS.PRICE().get((TRADABLE)TR.get(s.resource)) * s.consumptionPerPersonday * s.consumedMulPerDay(race()) * s.consumptionPerPersonday; 
/*     */     this.costPerMan = (int)Math.ceil(cost);
/*     */     this.indu = new Induvidual(HTYPES.SOLDIER(), race());
/*     */     (STATS.NEEDS()).DIRTINESS.setD(this.indu, RND.rExpo() * 0.5D);
/*     */     report(1);
/*     */   }
/*     */   
/*     */   protected void armyChange(WArmy old, WArmy newW) {
/*     */     if (newW == null) {
/*     */       this.disbandTime = (TIME.secondsPerDay() * 16 * 2);
/*     */     } else if (old != null || newW == null || newW.faction() == FACTIONS.player()) {
/*     */     
/*     */     } 
/*     */     this.missedPayments = -1;
/*     */     super.armyChange(old, newW);
/*     */   }
/*     */   
/*     */   public boolean disbanded() {
/*     */     return (this.disbandTime > 0.0F);
/*     */   }
/*     */   
/*     */   public void save(FilePutter file) {
/*     */     super.save(file);
/*     */     file.b(this.race);
/*     */     file.s(this.men);
/*     */     file.s(this.menTarget);
/*     */     file.f(this.exp);
/*     */     file.f(this.disbandTime);
/*     */     file.i(this.costPerMan);
/*     */     file.s(this.nameI);
/*     */     file.s(this.bannerI);
/*     */     this.spec.save(file);
/*     */     file.bool((this.indu != null));
/*     */     if (this.indu != null)
/*     */       this.indu.save(file); 
/*     */     file.b(this.missedPayments);
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*     */     super.load(file);
/*     */     this.race = file.b();
/*     */     this.men = file.s();
/*     */     this.menTarget = file.s();
/*     */     this.exp = file.f();
/*     */     this.disbandTime = file.f();
/*     */     this.costPerMan = file.i();
/*     */     this.nameI = file.s();
/*     */     this.bannerI = file.s();
/*     */     this.spec.load(file);
/*     */     if (file.bool())
/*     */       this.indu = new Induvidual(file); 
/*     */     this.missedPayments = file.b();
/*     */   }
/*     */   
/*     */   public Induvidual cheif() {
/*     */     return this.indu;
/*     */   }
/*     */   
/*     */   public int men() {
/*     */     return this.men;
/*     */   }
/*     */   
/*     */   public void menSet(int m) {
/*     */     report(-1);
/*     */     this.men = (short)CLAMP.i(m, 0, menTarget());
/*     */     report(1);
/*     */   }
/*     */   
/*     */   public void resolve(Induvidual[] hs) {
/*     */     double exp = 0.0D;
/*     */     byte b;
/*     */     int i;
/*     */     Induvidual[] arrayOfInduvidual;
/*     */     for (i = (arrayOfInduvidual = hs).length, b = 0; b < i; ) {
/*     */       Induvidual induvidual = arrayOfInduvidual[b];
/*     */       exp += (STATS.BATTLE()).COMBAT_EXPERIENCE.indu().getD(induvidual);
/*     */       b++;
/*     */     } 
/*     */     if (hs.length > 0)
/*     */       exp /= hs.length; 
/*     */     resolve(hs.length, exp);
/*     */   }
/*     */   
/*     */   public void resolve(int surviviors, double experiencePerMan) {
/*     */     menSet(surviviors);
/*     */     report(-1);
/*     */     this.exp = (float)CLAMP.d(experiencePerMan, 0.0D, 1.0D);
/*     */     report(1);
/*     */   }
/*     */   
/*     */   public int menTarget() {
/*     */     return this.menTarget;
/*     */   }
/*     */   
/*     */   public double training(StatsBattle.StatTraining tr) {
/*     */     return this.spec.training[tr.tIndex];
/*     */   }
/*     */   
/*     */   public double experience() {
/*     */     return this.exp;
/*     */   }
/*     */   
/*     */   public Race race() {
/*     */     return (Race)RACES.all().get(this.race & 0xFF);
/*     */   }
/*     */   
/*     */   public int daysUntilMenArrives() {
/*     */     return 1;
/*     */   }
/*     */   
/*     */   public int costPerMan() {
/*     */     return this.costPerMan;
/*     */   }
/*     */   
/*     */   public int type() {
/*     */     return 2;
/*     */   }
/*     */   
/*     */   public CharSequence name() {
/*     */     return (CharSequence)(race()).info.armyNames.get(this.nameI);
/*     */   }
/*     */   
/*     */   public double equip(EquipBattle e) {
/*     */     return this.spec.equip[e.indexMilitary()];
/*     */   }
/*     */   
/*     */   public boolean needSupplies() {
/*     */     return false;
/*     */   }
/*     */   
/*     */   public DivGeneration generate() {
/*     */     return new DivGeneration(this, this.target);
/*     */   }
/*     */   
/*     */   public int bannerI() {
/*     */     return this.bannerI;
/*     */   }
/*     */   
/*     */   public void bannerSet(int bi) {
/*     */     this.bannerI = (short)bi;
/*     */   }
/*     */   
/*     */   public COLOR color() {
/*     */     return col;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\WDivMercenary.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */