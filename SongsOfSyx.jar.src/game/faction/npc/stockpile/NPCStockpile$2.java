/*     */ package game.faction.npc.stockpile;
/*     */ 
/*     */ import init.trade.TR;
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
/*     */ class null
/*     */   implements SAVABLE
/*     */ {
/*     */   public void save(FilePutter file) {
/*  94 */     TR.MAP().saver().save((SAVABLE[])NPCStockpile.this.resses, file);
/*  95 */     file.d(NPCStockpile.this.workforce);
/*  96 */     NPCStockpile.this.price.save(file);
/*  97 */     NPCStockpile.this.forSale.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 102 */     TR.MAP().loader().load((SAVABLE[])NPCStockpile.this.resses, file);
/* 103 */     NPCStockpile.this.workforce = file.d();
/* 104 */     NPCStockpile.this.price.load(file);
/* 105 */     NPCStockpile.this.forSale.load(file);
/*     */   } public void clear() {
/*     */     byte b;
/*     */     int i;
/*     */     NPCRes[] arrayOfNPCRes;
/* 110 */     for (i = (arrayOfNPCRes = NPCStockpile.this.resses).length, b = 0; b < i; ) { NPCRes r = arrayOfNPCRes[b];
/* 111 */       r.clear(); b++; }
/* 112 */      NPCStockpile.this.workforce = 1.0D;
/* 113 */     NPCStockpile.this.price.clear();
/* 114 */     NPCStockpile.this.forSale.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\stockpile\NPCStockpile$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */