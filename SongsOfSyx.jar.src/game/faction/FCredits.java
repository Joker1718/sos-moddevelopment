/*     */ package game.faction;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.data.DOUBLE;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.statistics.HistoryInt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FCredits
/*     */   extends FactionResource
/*     */   implements DOUBLE
/*     */ {
/*     */   protected double credits;
/*  25 */   private static CharSequence ¤¤Treasury = "¤Treasury";
/*  26 */   private static CharSequence ¤¤TreasuryD = "¤The amount of Denari at disposal.";
/*     */   
/*  28 */   private static CharSequence ¤¤TRADE = "Trade";
/*  29 */   private static CharSequence ¤¤TRADED = "Money that flow through imports and exports.";
/*     */   
/*  31 */   private static CharSequence ¤¤INFLATION = "Inflation";
/*  32 */   private static CharSequence ¤¤INFLATIOND = "Over time, Inflation adds credits to a negative treasury and removes credits from a positive one.";
/*  33 */   private static CharSequence ¤¤MISC = "Misc";
/*  34 */   private static CharSequence ¤¤MISCD = "Special sources";
/*  35 */   private static CharSequence ¤¤TRIBUTE = "Tribute";
/*  36 */   private static CharSequence ¤¤TRIBUTED = "Denari spent/gained from paying off other armies and factions.";
/*     */   
/*  38 */   private static CharSequence ¤¤DIPLOMACYD = "Denari spent/gained from diplomacy with other factions.";
/*  39 */   private static CharSequence ¤¤MERCINARIES = "Mercenaries";
/*  40 */   private static CharSequence ¤¤MERCINARIESD = "Mercenaries can be conscripted into your armies and cost credits to upkeep each day.";
/*  41 */   private static CharSequence ¤¤TOURISM = "Tourism";
/*  42 */   private static CharSequence ¤¤TOURISMD = "Tourists that visit your city will give you some money at the end of their stay.";
/*  43 */   private static CharSequence ¤¤CONSTRUCTION = "Construction";
/*  44 */   private static CharSequence ¤¤CONSTRUCTIOND = "Construction of buildings in your kingdom.";
/*  45 */   private static CharSequence ¤¤TAX = "Tax";
/*  46 */   private static CharSequence ¤¤TAXD = "Taxation from the realm.";
/*  47 */   private static CharSequence ¤¤SLAVESD = "Transactions from slave trade.";
/*     */   private final HistoryInt creditsH;
/*     */   
/*     */   static {
/*  51 */     D.ts(FCredits.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FCredits(int saved, TIMECYCLE time) {
/*  60 */     this.creditsH = new HistoryInt(¤¤Treasury, ¤¤TreasuryD, saved, time, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  67 */     file.d(this.credits);
/*  68 */     this.creditsH.save(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  74 */     this.credits = file.d();
/*  75 */     this.creditsH.load(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {
/*  81 */     this.credits = 0.0D;
/*  82 */     this.creditsH.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Faction f) {
/*  88 */     double inf = this.credits * 0.2D * ds / TIME.years().bitSeconds() * (BOOSTABLES.CIVICS()).DEFALTION.get(f);
/*  89 */     int i = (int)inf;
/*     */     
/*  91 */     if (Math.abs(inf - i) > RND.rFloat()) {
/*  92 */       i = (int)(i + Math.signum(i));
/*     */     }
/*     */     
/*  95 */     inc(-i, CTYPE.INFLATION);
/*     */   }
/*     */ 
/*     */   
/*     */   public HISTORY_INT creditsH() {
/* 100 */     return (HISTORY_INT)this.creditsH;
/*     */   }
/*     */   
/*     */   public double credits() {
/* 104 */     return this.credits;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getD() {
/* 109 */     return this.credits;
/*     */   }
/*     */   
/*     */   protected void inccc(double amount) {
/* 113 */     this.credits += amount;
/* 114 */     this.creditsH.set((int)this.credits);
/*     */   }
/*     */   
/*     */   public void set(double amount) {
/* 118 */     this.credits = amount;
/*     */   }
/*     */   
/*     */   public void inc(double amount, CTYPE t) {
/* 122 */     inccc(amount);
/*     */   }
/*     */   
/*     */   public void inc(double amount, CTYPE t, TRADABLE res, int resAm) {
/* 126 */     inccc(amount);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum CTYPE
/*     */   {
/* 134 */     TRADE((String)FCredits.¤¤TRADE, FCredits.¤¤TRADED),
/* 135 */     INFLATION((String)FCredits.¤¤INFLATION, FCredits.¤¤INFLATIOND),
/* 136 */     MISC((String)FCredits.¤¤MISC, FCredits.¤¤MISCD),
/* 137 */     TRIBUTE((String)FCredits.¤¤TRIBUTE, FCredits.¤¤TRIBUTED),
/*     */     
/* 139 */     DIPLOMACY((String)Dic.¤¤Diplomacy, FCredits.¤¤DIPLOMACYD),
/* 140 */     MERCINARIES((String)FCredits.¤¤MERCINARIES, FCredits.¤¤MERCINARIESD),
/* 141 */     TOURISM((String)FCredits.¤¤TOURISM, FCredits.¤¤TOURISMD),
/* 142 */     CONSTRUCTION((String)FCredits.¤¤CONSTRUCTION, FCredits.¤¤CONSTRUCTIOND),
/* 143 */     TAX((String)FCredits.¤¤TAX, FCredits.¤¤TAXD),
/* 144 */     SLAVES((String)(HCLASSES.SLAVE()).name, FCredits.¤¤SLAVESD);
/*     */     
/*     */     public final CharSequence name;
/*     */     
/*     */     public final CharSequence desc;
/*     */     
/*     */     CTYPE(CharSequence name, CharSequence desc) {
/* 151 */       this.name = name;
/* 152 */       this.desc = desc;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\FCredits.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */