/*     */ package view.ui.div;
/*     */ 
/*     */ import game.GAME;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.common.BitmapSpriteEditor;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GColorPicker;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class UIDivBannerEditor
/*     */ {
/*  19 */   private int bannerI = 0;
/*  20 */   GuiSection pop = new GuiSection();
/*     */   
/*     */   RENDEROBJ prevPop;
/*     */   
/*     */   CLICKABLE prevPopC;
/*     */ 
/*     */   
/*     */   public UIDivBannerEditor() {
/*  28 */     final BitmapSpriteEditor ee = new BitmapSpriteEditor();
/*  29 */     ee.spriteSet(((GAME.ARMIES()).banners.get(0)).sprite);
/*     */     
/*  31 */     for (int i = 0; i < (GAME.ARMIES()).banners.size(); i++) {
/*  32 */       final int k = i;
/*     */       
/*  34 */       GButt.ButtPanel bu = new GButt.ButtPanel((SPRITE)(GAME.ARMIES()).banners.get(i))
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  38 */             UIDivBannerEditor.this.bannerISet(k);
/*  39 */             ee.spriteSet(((GAME.ARMIES()).banners.get(k)).sprite);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  44 */             selectedSet((UIDivBannerEditor.this.bannerI == k));
/*     */           }
/*     */         };
/*     */       
/*  48 */       bu.pad(2, 0);
/*  49 */       this.pop.add((RENDEROBJ)bu, i % 10 * bu.body.width(), i / 10 * bu.body.height());
/*     */     } 
/*     */     
/*  52 */     this.pop.addRelBody(8, DIR.S, (RENDEROBJ)ee);
/*     */     
/*  54 */     GuiSection c = new GuiSection();
/*     */     
/*  56 */     c.addRelBody(8, DIR.S, (RENDEROBJ)new GColorPicker(false)
/*     */         {
/*     */           public ColorImp color()
/*     */           {
/*  60 */             return ((GAME.ARMIES()).banners.get(UIDivBannerEditor.this.bannerI)).col;
/*     */           }
/*     */         });
/*     */     
/*  64 */     c.addRelBody(8, DIR.E, (RENDEROBJ)new GColorPicker(false)
/*     */         {
/*     */           public ColorImp color()
/*     */           {
/*  68 */             return ((GAME.ARMIES()).banners.get(UIDivBannerEditor.this.bannerI)).bg;
/*     */           }
/*     */         });
/*     */     
/*  72 */     this.pop.addRelBody(8, DIR.S, (RENDEROBJ)c);
/*     */     
/*  74 */     this.pop.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Accept)
/*     */         {
/*     */           protected void clickA() {
/*  77 */             (VIEW.inters()).popup.pop();
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public int bannerI() {
/*  83 */     return this.bannerI;
/*     */   }
/*     */   
/*     */   public void bannerISet(int i) {
/*  87 */     this.bannerI = i;
/*     */   }
/*     */   
/*     */   public RENDEROBJ view() {
/*  91 */     return (RENDEROBJ)this.pop;
/*     */   }
/*     */ 
/*     */   
/*     */   public CLICKABLE butt() {
/*  96 */     SPRITE.Imp imp = new SPRITE.Imp(32)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 100 */           (GAME.ARMIES()).banners.get(UIDivBannerEditor.this.bannerI()).render(r, X1 + 2, Y1 + 2);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 106 */     return (new GButt.ButtPanel((SPRITE)imp)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 110 */           (VIEW.inters()).popup.push(UIDivBannerEditor.this.view(), (CLICKABLE)this);
/*     */         }
/* 113 */       }).hoverTitleSet(Dic.¤¤Banner);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivBannerEditor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */