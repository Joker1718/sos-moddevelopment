/*    */ package view.ui.wiki;
/*    */ import init.constant.C;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.misc.GHeader;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ abstract class Article {
/*    */   public final String key;
/*    */   
/* 17 */   public final GuiSection section = new GuiSection()
/*    */     {
/*    */       public void render(SPRITE_RENDERER r, float ds) {
/* 20 */         Colors.border.render(r, (RECTANGLE)body(), -5);
/* 21 */         COLOR.WHITE05.render(r, (RECTANGLE)body(), -6);
/* 22 */         super.render(r, ds);
/*    */       }
/*    */     };
/* 25 */   public final CharSequence title; public final CharSequence category; public static final int HEIGHT = C.HEIGHT() - 0 - 32;
/*    */   
/*    */   Article(CharSequence title, CharSequence category) {
/* 28 */     this.title = title;
/* 29 */     this.category = category;
/* 30 */     this.key = String.valueOf(category) + String.valueOf(category);
/*    */   }
/*    */ 
/*    */   
/*    */   final void init(LIST<Article> all, int width) {
/* 35 */     this.section.body().setWidth(width);
/* 36 */     this.section.body().setHeight((C.HEIGHT() - 0 - 32));
/* 37 */     GHeader h = new GHeader(this.title);
/* 38 */     h.body().centerX((RECTANGLE)this.section.body());
/* 39 */     h.body().centerY(0.0D, 0.0D);
/* 40 */     this.section.add((RENDEROBJ)h);
/* 41 */     GButt.Glow b = new GButt.Glow((SPRITE)(SPRITES.icons()).m.exit)
/*    */       {
/*    */         protected void clickA() {
/* 44 */           (VIEW.UI()).wiki.remove(Article.this);
/*    */         }
/*    */       };
/* 47 */     b.body.centerY(0.0D, 0.0D);
/* 48 */     b.body.moveX2((width - 8));
/* 49 */     this.section.add((RENDEROBJ)b);
/* 50 */     GuiSection s = makeSection(all, width - 48);
/* 51 */     s.body().moveY1(6.0D);
/* 52 */     s.body().moveX1(24.0D);
/* 53 */     this.section.add((RENDEROBJ)s);
/*    */   }
/*    */   
/*    */   abstract GuiSection makeSection(LIST<Article> paramLIST, int paramInt);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\wiki\Article.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */