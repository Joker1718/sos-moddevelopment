/*    */ package init.sprite.game;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ public class Sheets
/*    */ {
/*    */   public final LIST<SheetPair> sheets;
/*    */   
/*    */   public Sheets(SheetType type, Json json) throws IOException {
/* 15 */     this.sheets = SPRITES.GAME().sheets(type, json);
/*    */   }
/*    */   
/*    */   public Sheets(Sheet s, SheetData d) throws IOException {
/* 19 */     this.sheets = (LIST<SheetPair>)new ArrayList(new SheetPair(s, d));
/*    */   }
/*    */   
/*    */   public SheetPair get(int random) {
/* 23 */     if (this.sheets.size() == 0)
/* 24 */       return null; 
/* 25 */     return (SheetPair)this.sheets.getC(random);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\game\Sheets.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */