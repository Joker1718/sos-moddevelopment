/*     */ package game.faction.player;
/*     */ 
/*     */ import game.VERSION;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TRADABLE;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT_O;
/*     */ import util.statistics.HistoryInt;
/*     */ import util.text.D;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.ui.economy.YearlyFinansials;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PCredits
/*     */   extends FCredits
/*     */ {
/*  33 */   public static int history = 48;
/*  34 */   private final ArrayListGrower<CredHistory> all = new ArrayListGrower();
/*  35 */   public final HistoryInt worth = new HistoryInt(64, (TIMECYCLE)TIME.seasons(), true);
/*  36 */   public final Yearly yearly = new Yearly();
/*  37 */   private int dayToSendMessage = (int)(TIME.years().bitsSinceStart() * TIME.years().bitConversion((TIMECYCLE)TIME.days()) + TIME.years().bitConversion((TIMECYCLE)TIME.days()) + 2.0D);
/*     */   
/*  39 */   private static CharSequence ¤¤turnover = "Yearly Turnover";
/*  40 */   private static CharSequence ¤¤profits = "Yearly Profits";
/*  41 */   private static CharSequence ¤¤losses = "Yearly losses";
/*     */   
/*     */   static {
/*  44 */     D.ts(PCredits.class);
/*     */   }
/*     */   
/*     */   public PCredits() {
/*  48 */     super(history, (TIMECYCLE)TIME.days());
/*     */     
/*  50 */     GVALUES.FACTION.pushI("CREDITS_YEARLY_TURNOVER", ¤¤turnover, (SPRITE)(UI.icons()).s.money, new VV(this.yearly.TURNOVER));
/*  51 */     GVALUES.FACTION.pushI("CREDITS_YEARLY_PROFITS", ¤¤profits, (SPRITE)(UI.icons()).s.money, new VV(this.yearly.PROFITS));
/*  52 */     GVALUES.FACTION.pushI("CREDITS_YEARLY_LOSSES", ¤¤losses, (SPRITE)(UI.icons()).s.money, new VV(this.yearly.LOSSES)); byte b; int i;
/*     */     FCredits.CTYPE[] arrayOfCTYPE;
/*  54 */     for (i = (arrayOfCTYPE = FCredits.CTYPE.values()).length, b = 0; b < i; ) { FCredits.CTYPE t = arrayOfCTYPE[b];
/*  55 */       CredHistory h = new CredHistory(t, 48, (TIMECYCLE)TIME.days());
/*  56 */       this.all.add(h);
/*  57 */       GVALUES.FACTION.pushI("CREDITS_YEARLY_TURNOVER_" + t.toString(), String.valueOf(¤¤turnover) + " (" + String.valueOf(¤¤turnover) + ")", (SPRITE)(UI.icons()).s.money, new VV(h.yearly.TURNOVER));
/*  58 */       GVALUES.FACTION.pushI("CREDITS_YEARLY_PROFITS_" + t.toString(), String.valueOf(¤¤profits) + " (" + String.valueOf(¤¤profits) + ")", (SPRITE)(UI.icons()).s.money, new VV(h.yearly.PROFITS));
/*  59 */       GVALUES.FACTION.pushI("CREDITS_YEARLY_LOSSES_" + t.toString(), String.valueOf(¤¤losses) + " (" + String.valueOf(¤¤losses) + ")", (SPRITE)(UI.icons()).s.money, new VV(h.yearly.LOSSES));
/*     */       
/*     */       b++; }
/*     */     
/*  63 */     IDebugPanelSett.add("YEARLY FINANSIALS", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  67 */             (new YearlyFinansials()).send();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   private class VV
/*     */     implements INT_O<Faction>
/*     */   {
/*     */     private final HistoryInt ii;
/*     */     
/*     */     VV(HistoryInt ii) {
/*  78 */       this.ii = ii;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get(Faction t) {
/*  83 */       if (t == FACTIONS.player())
/*  84 */         return this.ii.get(); 
/*  85 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int min(Faction t) {
/*  90 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max(Faction t) {
/*  95 */       return Integer.MAX_VALUE;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Faction f) {
/* 103 */     this.worth.set((int)FACTIONS.WORTH().faction(FACTIONS.player()));
/* 104 */     super.update(ds, f);
/*     */     
/* 106 */     if (TIME.days().bitsSinceStart() >= this.dayToSendMessage) {
/* 107 */       this.dayToSendMessage = (int)(TIME.years().bitsSinceStart() * TIME.years().bitConversion((TIMECYCLE)TIME.days()) + TIME.years().bitConversion((TIMECYCLE)TIME.days()) + 2.0D);
/* 108 */       (new YearlyFinansials()).send();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void inc(double amount, FCredits.CTYPE t) {
/* 119 */     if (amount < 0.0D) {
/* 120 */       ((CredHistory)this.all.get(t.ordinal())).OUT.inc((int)-amount);
/*     */     } else {
/* 122 */       ((CredHistory)this.all.get(t.ordinal())).IN.inc((int)amount);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void inc(double amount, FCredits.CTYPE t, TRADABLE res, int resAm) {
/* 127 */     inc(amount, t);
/* 128 */     if (t == FCredits.CTYPE.TRADE) {
/* 129 */       (FACTIONS.player()).trade.trade(amount, res, resAm);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 138 */     file.i(this.all.size());
/* 139 */     for (CredHistory h : this.all)
/* 140 */       h.saver.save(file); 
/* 141 */     this.worth.save(file);
/* 142 */     this.yearly.save(file);
/* 143 */     file.i(this.dayToSendMessage);
/* 144 */     super.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 149 */     int l = file.i();
/* 150 */     if (l != this.all.size()) {
/* 151 */       for (int i = 0; i < l; i++)
/* 152 */         ((CredHistory)this.all.get(0)).saver.load(file); 
/* 153 */       clear();
/*     */     } else {
/* 155 */       for (CredHistory h : this.all)
/* 156 */         h.saver.load(file); 
/*     */     } 
/* 158 */     this.worth.load(file);
/* 159 */     this.yearly.load(file);
/* 160 */     if (!VERSION.versionIsBefore(71, 2))
/* 161 */       this.dayToSendMessage = file.i(); 
/* 162 */     super.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 167 */     for (CredHistory h : this.all)
/* 168 */       h.saver.clear(); 
/* 169 */     this.worth.clear();
/* 170 */     this.yearly.clear();
/* 171 */     super.clear();
/*     */   }
/*     */   
/*     */   public LIST<CredHistory> all() {
/* 175 */     return (LIST<CredHistory>)this.all;
/*     */   }
/*     */   
/*     */   public CredHistory get(FCredits.CTYPE type) {
/* 179 */     return (CredHistory)this.all.get(type.ordinal());
/*     */   }
/*     */   
/*     */   public class CredHistory
/*     */   {
/*     */     public final FCredits.CTYPE type;
/*     */     public final HistoryInt IN;
/*     */     public final HistoryInt OUT;
/* 187 */     public final PCredits.Yearly yearly = new PCredits.Yearly();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final SAVABLE saver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CredHistory(FCredits.CTYPE type, int saved, TIMECYCLE time) {
/* 216 */       this.saver = new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/* 220 */             PCredits.CredHistory.this.IN.save(file);
/* 221 */             PCredits.CredHistory.this.OUT.save(file);
/* 222 */             PCredits.CredHistory.this.yearly.save(file);
/*     */           }
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/* 227 */             PCredits.CredHistory.this.IN.load(file);
/* 228 */             PCredits.CredHistory.this.OUT.load(file);
/* 229 */             PCredits.CredHistory.this.yearly.load(file);
/*     */           }
/*     */           
/*     */           public void clear()
/*     */           {
/* 234 */             PCredits.CredHistory.this.IN.clear();
/* 235 */             PCredits.CredHistory.this.OUT.clear();
/* 236 */             PCredits.CredHistory.this.yearly.clear(); } }; this.IN = new HistoryInt(saved, time, false) { protected void change(int old, int current) { PCredits.CredHistory.access$0(PCredits.CredHistory.this).inccc((current - old)); PCredits.CredHistory.this.yearly.PROFITS.inc(current - old); PCredits.CredHistory.this.yearly.TURNOVER.inc(current - old); (PCredits.CredHistory.access$0(PCredits.CredHistory.this)).yearly.PROFITS.inc(current - old);
/*     */             (PCredits.CredHistory.access$0(PCredits.CredHistory.this)).yearly.TURNOVER.inc(current - old); } };
/*     */       this.OUT = new HistoryInt(saved, time, false) { protected void change(int old, int current) { PCredits.CredHistory.access$0(PCredits.CredHistory.this).inccc(-(current - old));
/*     */             PCredits.CredHistory.this.yearly.LOSSES.inc(-(current - old));
/*     */             PCredits.CredHistory.this.yearly.TURNOVER.inc(-(current - old));
/*     */             (PCredits.CredHistory.access$0(PCredits.CredHistory.this)).yearly.PROFITS.inc(-(current - old));
/*     */             (PCredits.CredHistory.access$0(PCredits.CredHistory.this)).yearly.TURNOVER.inc(-(current - old)); } };
/*     */       this.type = type;
/*     */     }
/* 245 */   } public final class Yearly { public final HistoryInt TURNOVER; public Yearly() { this.TURNOVER = new HistoryInt(64, (TIMECYCLE)TIME.years(), false);
/* 246 */       this.PROFITS = new HistoryInt(64, (TIMECYCLE)TIME.years(), false);
/* 247 */       this.LOSSES = new HistoryInt(64, (TIMECYCLE)TIME.years(), false); }
/*     */      public final HistoryInt PROFITS; public final HistoryInt LOSSES;
/*     */     void save(FilePutter file) {
/* 250 */       this.TURNOVER.save(file);
/* 251 */       this.PROFITS.save(file);
/* 252 */       this.LOSSES.save(file);
/*     */     }
/*     */     
/*     */     void load(FileGetter file) throws IOException {
/* 256 */       this.TURNOVER.load(file);
/* 257 */       this.PROFITS.load(file);
/* 258 */       this.LOSSES.load(file);
/*     */     }
/*     */     
/*     */     void clear() {
/* 262 */       this.TURNOVER.clear();
/* 263 */       this.PROFITS.clear();
/* 264 */       this.LOSSES.clear();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PCredits.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */