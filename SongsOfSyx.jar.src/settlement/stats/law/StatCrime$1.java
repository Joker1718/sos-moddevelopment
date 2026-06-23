/*     */ package settlement.stats.law;
/*     */ 
/*     */ import game.VERSION;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements SAVABLE
/*     */ {
/*     */   public void save(FilePutter file) {
/*  76 */     HCLASS_RACE.MAP().saver().save(StatCrime.this.autoPunishment, file);
/*  77 */     StatCrime.this.occurence.save(file);
/*  78 */     StatCrime.this.caught.save(file);
/*  79 */     file.dsE(StatCrime.this.recentPunishments);
/*  80 */     file.dsE(StatCrime.this.freedom);
/*  81 */     file.dsE(StatCrime.this.loyalty);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  86 */     clear();
/*  87 */     HCLASS_RACE.MAP().loader().load(StatCrime.this.autoPunishment, file, 0);
/*  88 */     StatCrime.this.occurence.load(file);
/*  89 */     StatCrime.this.caught.load(file);
/*  90 */     file.dsE(StatCrime.this.recentPunishments);
/*  91 */     file.dsE(StatCrime.this.freedom);
/*  92 */     file.dsE(StatCrime.this.loyalty);
/*  93 */     if (VERSION.versionIsBefore(71, 23)) {
/*  94 */       StatCrime.this.setPunishments();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 100 */     StatCrime.this.criminalsTot = 0;
/* 101 */     Arrays.fill(StatCrime.this.criminals, 0);
/* 102 */     StatCrime.this.occurence.clear();
/* 103 */     StatCrime.this.caught.clear();
/* 104 */     Arrays.fill(StatCrime.this.recentPunishments, 0.0D);
/* 105 */     Arrays.fill(StatCrime.this.freedom, 0.0D);
/* 106 */     Arrays.fill(StatCrime.this.loyalty, 0.0D);
/* 107 */     StatCrime.this.setPunishments();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\StatCrime$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */