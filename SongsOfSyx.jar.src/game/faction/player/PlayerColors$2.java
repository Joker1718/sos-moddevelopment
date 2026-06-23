/*    */ package game.faction.player;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LinkedList;
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
/* 63 */     int am = 0;
/* 64 */     for (LinkedList<PlayerColors.PlayerColor> li : (Iterable<LinkedList<PlayerColors.PlayerColor>>)PlayerColors.cats.all()) {
/* 65 */       am += li.size();
/*    */     }
/* 67 */     file.i(am);
/* 68 */     for (LinkedList<PlayerColors.PlayerColor> li : (Iterable<LinkedList<PlayerColors.PlayerColor>>)PlayerColors.cats.all()) {
/* 69 */       for (PlayerColors.PlayerColor col : li) {
/* 70 */         file.chars(col.cat + col.cat);
/* 71 */         col.color.save(file);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 78 */     KeyMap<PlayerColors.PlayerColor> map = new KeyMap();
/* 79 */     for (LinkedList<PlayerColors.PlayerColor> li : (Iterable<LinkedList<PlayerColors.PlayerColor>>)PlayerColors.cats.all()) {
/* 80 */       for (PlayerColors.PlayerColor col : li) {
/* 81 */         map.put(col.cat + col.cat, col);
/*    */       }
/*    */     } 
/* 84 */     int am = file.i();
/* 85 */     while (am-- > 0) {
/* 86 */       String k = file.chars();
/* 87 */       ColorImp c = new ColorImp();
/* 88 */       c.load(file);
/* 89 */       if (map.containsKey(k)) {
/* 90 */         ((PlayerColors.PlayerColor)map.get(k)).color.set((COLOR)c);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 97 */     for (LinkedList<PlayerColors.PlayerColor> li : (Iterable<LinkedList<PlayerColors.PlayerColor>>)PlayerColors.cats.all()) {
/* 98 */       for (PlayerColors.PlayerColor col : li)
/* 99 */         col.color.set(col.def); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PlayerColors$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */