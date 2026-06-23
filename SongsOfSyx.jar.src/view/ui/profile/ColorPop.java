/*     */ package view.ui.profile;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FactionProfileFlusher;
/*     */ import game.faction.player.PlayerColors;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GColorPicker;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ class ColorPop
/*     */   extends ISidePanel
/*     */ {
/*  31 */   static CharSequence ¤¤name = "Color Masks";
/*     */   static {
/*  33 */     D.ts(ColorPop.class);
/*     */   }
/*     */   
/*     */   private PlayerColors.PlayerColor color;
/*     */   
/*     */   ColorPop() {
/*  39 */     titleSet(¤¤name);
/*     */ 
/*     */     
/*  42 */     this.section.add((RENDEROBJ)new GColorPicker(true)
/*     */         {
/*     */           public ColorImp color()
/*     */           {
/*  46 */             return ColorPop.this.color.color;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  51 */     GButt.ButtPanel buttPanel = new GButt.ButtPanel(Dic.¤¤save)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  55 */           FactionProfileFlusher.flush(FACTIONS.player());
/*     */         }
/*     */       };
/*  58 */     ((GButt)buttPanel).body.setWidth(200.0D);
/*  59 */     this.section.addRelBody(16, DIR.S, (RENDEROBJ)buttPanel);
/*     */     
/*  61 */     buttPanel = new GButt.ButtPanel(Dic.¤¤Reset)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  65 */           PlayerColors.saver.clear();
/*     */         }
/*     */       };
/*  68 */     ((GButt)buttPanel).body.setWidth(200.0D);
/*  69 */     this.section.addRelBody(0, DIR.S, (RENDEROBJ)buttPanel);
/*     */ 
/*     */     
/*  72 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/*  74 */     for (String cat : PlayerColors.cats().keysSorted()) {
/*  75 */       rows.add(new GTextR((new GText((UI.FONT()).S, cat)).lablify()));
/*  76 */       for (PlayerColors.PlayerColor c : PlayerColors.cats().get(cat)) {
/*  77 */         Text t = new Text((UI.FONT()).S, c.name);
/*  78 */         t.setMaxChars(16);
/*  79 */         if (this.color == null)
/*  80 */           this.color = c; 
/*  81 */         GButt.ButtPanel buttPanel1 = new GButt.ButtPanel((SPRITE)t)
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX text)
/*     */             {
/*  85 */               text.text(c.name);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/*  90 */               ColorPop.this.color = c;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/*  95 */               selectedSet((ColorPop.this.color == c));
/*     */             }
/*     */           };
/*     */         
/*  99 */         ((GButt)buttPanel1).body.setWidth(220.0D);
/* 100 */         rows.add(buttPanel1);
/*     */       } 
/*     */     } 
/*     */     
/* 104 */     this.section.addRelBody(4, DIR.N, (RENDEROBJ)(new GScrollRows((Iterable)rows, HEIGHT - this.section.body().height() - 8)).view());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CLICKABLE butt() {
/* 110 */     SPRITE s = new SPRITE()
/*     */       {
/*     */         public int width()
/*     */         {
/* 114 */           return 32;
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 119 */           return 84;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 130 */           int x1 = X1 + 4;
/* 131 */           (UI.icons()).m.place_brush.render(r, x1, Y1 + 4);
/* 132 */           COLOR.RED100.render(r, x1, X2 - 4, Y1 + 32, Y1 + 32 + 16);
/* 133 */           COLOR.GREEN100.render(r, x1, X2 - 4, Y1 + 32 + 16, Y1 + 32 + 16 + 16);
/* 134 */           COLOR.BLUE100.render(r, x1, X2 - 4, Y1 + 32 + 16 + 16, Y1 + 32 + 16 + 16 + 16);
/*     */         }
/*     */       };
/*     */     
/* 138 */     return (new GButt.ButtPanel(s)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 142 */           VIEW.s().activate();
/* 143 */           (VIEW.s()).panels.add(ColorPop.this, true);
/* 144 */           (VIEW.inters()).manager.clear();
/*     */         }
/* 147 */       }).hoverInfoSet(¤¤name);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\ColorPop.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */