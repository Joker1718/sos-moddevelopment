/*    */ package view.ui.tourism;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.Dic;
/*    */ import view.ui.manage.IFullView;
/*    */ 
/*    */ public final class UITourists extends IFullView {
/*    */   public UITourists() {
/* 11 */     super(Dic.¤¤Tourists, (SPRITE)(UI.icons()).l.tourist);
/* 12 */     this.section.body().setWidth(WIDTH).setHeight(1.0D);
/*    */     
/* 14 */     this.section.addDownC(0, (RENDEROBJ)new Tourism(HEIGHT));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tourism\UITourists.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */