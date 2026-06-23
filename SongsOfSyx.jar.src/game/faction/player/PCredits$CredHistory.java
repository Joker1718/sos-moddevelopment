/*     */ package game.faction.player;
/*     */ 
/*     */ import game.faction.FCredits;
/*     */ import game.time.TIMECYCLE;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.statistics.HistoryInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CredHistory
/*     */ {
/*     */   public final FCredits.CTYPE type;
/*     */   public final HistoryInt IN;
/*     */   public final HistoryInt OUT;
/*     */   public final PCredits.Yearly yearly;
/*     */   public final SAVABLE saver;
/*     */   
/*     */   public CredHistory(FCredits.CTYPE type, int saved, TIMECYCLE time) {
/* 187 */     this.yearly = new PCredits.Yearly(paramPCredits);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 220 */           PCredits.CredHistory.this.IN.save(file);
/* 221 */           PCredits.CredHistory.this.OUT.save(file);
/* 222 */           PCredits.CredHistory.this.yearly.save(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 227 */           PCredits.CredHistory.this.IN.load(file);
/* 228 */           PCredits.CredHistory.this.OUT.load(file);
/* 229 */           PCredits.CredHistory.this.yearly.load(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 234 */           PCredits.CredHistory.this.IN.clear();
/* 235 */           PCredits.CredHistory.this.OUT.clear();
/* 236 */           PCredits.CredHistory.this.yearly.clear();
/*     */         }
/*     */       };
/*     */     this.IN = new HistoryInt(saved, time, false) {
/*     */         protected void change(int old, int current) {
/*     */           PCredits.access$0(PCredits.CredHistory.access$0(PCredits.CredHistory.this), (current - old));
/*     */           PCredits.CredHistory.this.yearly.PROFITS.inc(current - old);
/*     */           PCredits.CredHistory.this.yearly.TURNOVER.inc(current - old);
/*     */           (PCredits.CredHistory.access$0(PCredits.CredHistory.this)).yearly.PROFITS.inc(current - old);
/*     */           (PCredits.CredHistory.access$0(PCredits.CredHistory.this)).yearly.TURNOVER.inc(current - old);
/*     */         }
/*     */       };
/*     */     this.OUT = new HistoryInt(saved, time, false) {
/*     */         protected void change(int old, int current) {
/*     */           PCredits.access$0(PCredits.CredHistory.access$0(PCredits.CredHistory.this), -(current - old));
/*     */           PCredits.CredHistory.this.yearly.LOSSES.inc(-(current - old));
/*     */           PCredits.CredHistory.this.yearly.TURNOVER.inc(-(current - old));
/*     */           (PCredits.CredHistory.access$0(PCredits.CredHistory.this)).yearly.PROFITS.inc(-(current - old));
/*     */           (PCredits.CredHistory.access$0(PCredits.CredHistory.this)).yearly.TURNOVER.inc(-(current - old));
/*     */         }
/*     */       };
/*     */     this.type = type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PCredits$CredHistory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */