/*    */ package settlement.main;
/*    */ 
/*    */ import init.type.CLIMATE;
/*    */ import init.type.CLIMATES;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements SAVABLE
/*    */ {
/*    */   public void save(FilePutter file) {
/* 41 */     CapitolArea.this.tiles.save(file);
/* 42 */     file.i(CapitolArea.this.arrivalTile);
/* 43 */     CapitolArea.this.worldPixels.save(file);
/* 44 */     CapitolArea.this.worldTiles.save(file);
/* 45 */     file.i(CapitolArea.this.climate.index());
/* 46 */     file.bool(CapitolArea.this.isBattle);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 51 */     CapitolArea.this.tiles.load(file);
/* 52 */     CapitolArea.this.arrivalTile = file.i();
/* 53 */     CapitolArea.this.worldPixels.load(file);
/* 54 */     CapitolArea.this.worldTiles.load(file);
/* 55 */     CapitolArea.this.climate = (CLIMATE)CLIMATES.ALL().get(file.i());
/* 56 */     CapitolArea.this.isBattle = file.bool();
/*    */   }
/*    */   
/*    */   public void clear() {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\main\CapitolArea$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */