/*    */ package util.gui.common;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GHeader;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.INFO;
/*    */ 
/*    */ public interface TITLEABLE
/*    */   extends SPRITE {
/*    */   default HOVERABLE hv(CharSequence name) {
/* 15 */     return (HOVERABLE)new GHeader.HeaderVertical(name, this);
/*    */   }
/*    */   
/*    */   default HOVERABLE hv(CharSequence name, CharSequence desc) {
/* 19 */     return (new GHeader.HeaderVertical(name, this)).hoverInfoSet(desc);
/*    */   }
/*    */   
/*    */   default HOVERABLE hv(INFO info) {
/* 23 */     return (new GHeader.HeaderVertical(info.name, this)).hoverTitleSet(info.name).hoverInfoSet(info.desc);
/*    */   }
/*    */   
/*    */   default HOVERABLE hv(SPRITE name) {
/* 27 */     return (HOVERABLE)new GHeader.HeaderVertical(name, this);
/*    */   }
/*    */   
/*    */   default HOVERABLE hh(CharSequence name) {
/* 31 */     return (HOVERABLE)new GHeader.HeaderHorizontal(name, this);
/*    */   }
/*    */   
/*    */   default HOVERABLE hhw(CharSequence name, int trail) {
/* 35 */     GHeader.HeaderHorizontal h = new GHeader.HeaderHorizontal(name, this);
/* 36 */     h.body().incrW(trail);
/* 37 */     return (HOVERABLE)h;
/*    */   }
/*    */   
/*    */   default HOVERABLE hhw(SPRITE name, int trail) {
/* 41 */     GHeader.HeaderHorizontal h = new GHeader.HeaderHorizontal(name, this);
/* 42 */     h.body().incrW(trail);
/* 43 */     return (HOVERABLE)h;
/*    */   }
/*    */   
/*    */   default HOVERABLE hh(INFO info) {
/* 47 */     return (new GHeader.HeaderHorizontal(info.name, this)).hoverInfoSet(info.desc);
/*    */   }
/*    */   
/*    */   default HOVERABLE hh(SPRITE name) {
/* 51 */     return (HOVERABLE)new GHeader.HeaderHorizontal(name, this);
/*    */   }
/*    */   
/*    */   default HOVERABLE hh(SPRITE name, int width) {
/* 55 */     return (HOVERABLE)new GHeader.HeaderHorizontal(name, this, width);
/*    */   }
/*    */ 
/*    */   
/*    */   default GHeader.HeaderHorizontal hh(CharSequence name, int width) {
/* 60 */     return new GHeader.HeaderHorizontal(name, this, width);
/*    */   }
/*    */ 
/*    */   
/*    */   default GHeader.HeaderHorizontal hh(final SPRITE icon, CharSequence name, int width) {
/* 65 */     final GText t = (new GText((UI.FONT()).S, name)).lablify();
/* 66 */     SPRITE ii = icon.resized(t.height());
/* 67 */     SPRITE.Imp imp = new SPRITE.Imp(ii.width() + 4 + t.width(), t.height())
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */         {
/* 71 */           icon.render(r, X1, Y1);
/* 72 */           t.render(r, X1 + t.height() + 4, Y1);
/*    */         }
/*    */       };
/*    */     
/* 76 */     return new GHeader.HeaderHorizontal((SPRITE)imp, this, width);
/*    */   }
/*    */   
/*    */   default GHeader.HeaderHorizontal hh(CharSequence name, CharSequence desc, int width) {
/* 80 */     GHeader.HeaderHorizontal h = new GHeader.HeaderHorizontal(name, this, width);
/* 81 */     h.hoverTitleSet(name);
/* 82 */     h.hoverInfoSet(desc);
/* 83 */     return h;
/*    */   }
/*    */ 
/*    */   
/*    */   default GHeader.HeaderHorizontal hh(CharSequence name, CharSequence desc) {
/* 88 */     GHeader.HeaderHorizontal h = new GHeader.HeaderHorizontal(name, this);
/* 89 */     h.hoverTitleSet(name);
/* 90 */     h.hoverInfoSet(desc);
/* 91 */     return h;
/*    */   }
/*    */   
/*    */   default void hoverInfoGet(GBox b) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\TITLEABLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */