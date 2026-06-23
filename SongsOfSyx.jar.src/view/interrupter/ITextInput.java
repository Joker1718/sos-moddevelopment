/*     */ package view.interrupter;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.text.Dic;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ public final class ITextInput extends Interrupter {
/*  26 */   private final GuiSection s = new GuiSection();
/*  27 */   private final Str title = new Str(64);
/*     */   
/*     */   private final GInput in;
/*     */   
/*     */   private STRING_RECIEVER client;
/*     */   private final InterManager m;
/*     */   
/*     */   public ITextInput(InterManager m) {
/*  35 */     this.m = m;
/*     */ 
/*     */     
/*  38 */     this.s.addDownC(0, (SPRITE)new SPRITE.Imp(400, (UI.FONT()).H2.height() * 2)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  42 */             (GCOLOR.T()).H1.bind();
/*  43 */             (UI.FONT()).H2.renderIn(r, X1, Y1, DIR.C, (CharSequence)ITextInput.this.title, width(), height(), 1.0D);
/*  44 */             COLOR.unbind();
/*     */           }
/*     */         });
/*     */     
/*  48 */     final StringInputSprite input = new StringInputSprite(48, (UI.FONT()).M);
/*  49 */     this.in = new GInput(input);
/*     */ 
/*     */     
/*  52 */     this.s.addRelBody(16, DIR.S, (RENDEROBJ)this.in);
/*     */     
/*  54 */     GuiSection buttons = new GuiSection();
/*     */     
/*  56 */     buttons.add((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.ok)
/*     */         {
/*     */           protected void clickA() {
/*  59 */             ITextInput.this.hide();
/*  60 */             ITextInput.this.client.acceptString((CharSequence)input.text());
/*     */           }
/*  62 */         }).hoverTitleSet(Dic.¤¤OK));
/*     */     
/*  64 */     buttons.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.cancel)
/*     */         {
/*     */           protected void clickA() {
/*  67 */             ITextInput.this.hide();
/*  68 */             ITextInput.this.client.acceptString(null);
/*     */           }
/*  70 */         }).hoverTitleSet(Dic.¤¤cancel));
/*     */     
/*  72 */     this.s.addRelBody(16, DIR.S, (RENDEROBJ)buttons);
/*     */     
/*  74 */     this.s.pad(8, 8);
/*     */     
/*  76 */     GPanel p = new GPanel((RECTANGLE)this.s.body());
/*  77 */     p.setBig();
/*     */ 
/*     */     
/*  80 */     this.s.add((RENDEROBJ)p);
/*  81 */     this.s.moveLastToBack();
/*     */     
/*  83 */     this.s.body().centerIn(C.DIM());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/*  90 */     this.in.listen();
/*  91 */     this.s.render((SPRITE_RENDERER)r, ds);
/*     */     
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void requestInput(STRING_RECIEVER client, CharSequence title) {
/* 101 */     requestInput(client, title, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void requestInput(STRING_RECIEVER client, CharSequence title, CharSequence placeholder) {
/* 106 */     this.title.clear().add(title);
/* 107 */     this.client = client;
/* 108 */     this.in.text().clear();
/* 109 */     if (placeholder != null)
/* 110 */       this.in.text().add(placeholder); 
/* 111 */     this.in.focus();
/* 112 */     show(this.m);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 117 */     this.s.hover(mCoo);
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 124 */     this.s.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 128 */     this.s.click();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 134 */     if ((KEYS.MAIN()).ESCAPE.consumeClick() || MButt.RIGHT.isDown()) {
/* 135 */       this.client.acceptString(null);
/* 136 */       hide();
/* 137 */     } else if ((KEYS.MAIN()).ENTER.consumeClick()) {
/* 138 */       hide();
/* 139 */       this.client.acceptString((CharSequence)this.in.text());
/*     */     } 
/* 141 */     KEYS.clear();
/*     */     
/* 143 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\ITextInput.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */