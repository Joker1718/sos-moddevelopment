/*    */ package world.map.regions;
/*    */ 
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.misc.STRING_RECIEVER;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.Dic;
/*    */ import view.main.VIEW;
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 75 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 79 */     (VIEW.inters()).input.requestInput(new STRING_RECIEVER()
/*    */         {
/*    */           public void acceptString(CharSequence string)
/*    */           {
/* 83 */             if (string != null)
/* 84 */               (Placer.null.access$0(Placer.null.this).get()).info.name().clear().add(string); 
/*    */           }
/* 86 */         },  Dic.¤¤name);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 91 */     text.text((CharSequence)(Placer.this.get()).info.name());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\Placer$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */