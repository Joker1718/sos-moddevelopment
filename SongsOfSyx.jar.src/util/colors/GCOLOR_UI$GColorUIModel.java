/*    */ package util.colors;
/*    */ 
/*    */ import snake2d.util.color.COLOR;
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
/*    */ public class GColorUIModel
/*    */ {
/*    */   public final COLOR normal;
/*    */   public final COLOR hovered;
/*    */   public final COLOR selected;
/*    */   public final COLOR inactive;
/*    */   
/*    */   private GColorUIModel(COLOR color) {
/* 46 */     this.inactive = (COLOR)color.shade(0.55D);
/* 47 */     this.normal = (COLOR)color.shade(0.8D);
/* 48 */     this.hovered = color;
/* 49 */     this.selected = (COLOR)color.shade(1.2D);
/*    */   }
/*    */   
/*    */   public COLOR get(boolean isActive, boolean isSelected, boolean isHovered) {
/* 53 */     if (!isActive)
/* 54 */       return this.inactive; 
/* 55 */     if (isHovered)
/* 56 */       return this.hovered; 
/* 57 */     if (isSelected)
/* 58 */       return this.selected; 
/* 59 */     return this.normal;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\colors\GCOLOR_UI$GColorUIModel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */