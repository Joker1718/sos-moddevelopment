/*    */ package world.map.landmark;
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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 53 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 57 */     (VIEW.inters()).input.requestInput(new STRING_RECIEVER()
/*    */         {
/*    */           public void acceptString(CharSequence string)
/*    */           {
/* 61 */             if (string != null)
/* 62 */               (Placers.null.access$0(Placers.null.this).get()).name.clear().add(string); 
/*    */           }
/* 64 */         },  Dic.¤¤name);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 69 */     text.text((CharSequence)(Placers.this.get()).name);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\Placers$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */