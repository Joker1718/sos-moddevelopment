/*     */ package game.faction.player;
/*     */ 
/*     */ import java.io.IOException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 132 */     PTrade.this.pricesBuy.save(file);
/* 133 */     PTrade.this.pricesSell.save(file);
/* 134 */     PTrade.this.pricesAve.save(file);
/* 135 */     PTrade.this.outImported.save(file);
/* 136 */     PTrade.this.inExported.save(file);
/* 137 */     PTrade.this.unitsImported.save(file);
/* 138 */     PTrade.this.unitsExported.save(file);
/* 139 */     PTrade.this.priceImported.save(file);
/* 140 */     PTrade.this.priceExported.save(file);
/* 141 */     file.i(PTrade.this.ri);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 146 */     PTrade.this.pricesBuy.load(file);
/* 147 */     PTrade.this.pricesSell.load(file);
/* 148 */     PTrade.this.pricesAve.load(file);
/* 149 */     PTrade.this.outImported.load(file);
/* 150 */     PTrade.this.inExported.load(file);
/* 151 */     PTrade.this.unitsImported.load(file);
/* 152 */     PTrade.this.unitsExported.load(file);
/* 153 */     PTrade.this.priceImported.load(file);
/* 154 */     PTrade.this.priceExported.load(file);
/* 155 */     PTrade.this.ri = file.i();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 161 */     PTrade.this.pricesBuy.clear();
/* 162 */     PTrade.this.pricesSell.clear();
/* 163 */     PTrade.this.pricesAve.clear();
/* 164 */     PTrade.this.outImported.clear();
/* 165 */     PTrade.this.inExported.clear();
/* 166 */     PTrade.this.unitsImported.clear();
/* 167 */     PTrade.this.unitsExported.clear();
/* 168 */     PTrade.this.priceImported.clear();
/* 169 */     PTrade.this.priceExported.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PTrade$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */