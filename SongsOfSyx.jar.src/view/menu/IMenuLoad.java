/*    */ package view.menu;
/*    */ 
/*    */ import game.save.GameLoader;
/*    */ import game.save.SaveFile;
/*    */ import init.paths.PATH;
/*    */ import init.paths.PATHS;
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.colors.GCOLOR;
/*    */ 
/*    */ class IMenuLoad extends GuiSection {
/*    */   IMenuLoad(final IMenu m) {
/* 15 */     this.m = new MenuScreenLoad(MenuScreenLoad.¤¤name, (GCOLOR.T()).H1, true, PATHS.local().save())
/*    */       {
/*    */         protected void load(SaveFile f)
/*    */         {
/* 19 */           SPRITES.loader().printempty();
/* 20 */           (new GameLoader(f.path, new String[0])).set();
/*    */         }
/*    */ 
/*    */         
/*    */         protected void back() {
/* 25 */           m.setMain();
/*    */         }
/*    */       };
/*    */     
/* 29 */     add((RENDEROBJ)this.m);
/*    */   }
/*    */   
/*    */   final MenuScreenLoad m;
/*    */   
/*    */   public void init() {
/* 35 */     this.m.populateSaves();
/*    */   }
/*    */   
/*    */   public void setOther() {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\IMenuLoad.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */