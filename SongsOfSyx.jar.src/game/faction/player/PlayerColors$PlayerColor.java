/*    */ package game.faction.player;
/*    */ 
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
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
/*    */ public class PlayerColor
/*    */ {
/*    */   public final ColorImp color;
/*    */   public final COLOR def;
/*    */   public final CharSequence name;
/*    */   public final String cat;
/*    */   public final String key;
/*    */   
/*    */   public PlayerColor(String key, CharSequence category, CharSequence name) {
/* 43 */     this(new ColorImp(), key, category, name);
/*    */   }
/*    */   
/*    */   public PlayerColor(ColorImp col, String key, CharSequence category, CharSequence name) {
/* 47 */     this.key = key;
/* 48 */     this.cat = String.valueOf(category);
/* 49 */     this.name = name;
/* 50 */     this.color = col;
/* 51 */     this.def = (COLOR)new ColorImp((COLOR)col);
/* 52 */     if (!PlayerColors.cats.containsKey(this.cat))
/* 53 */       PlayerColors.cats.put(this.cat, new LinkedList()); 
/* 54 */     ((LinkedList)PlayerColors.cats.get(this.cat)).add(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PlayerColors$PlayerColor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */