/*     */ package view.menu;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.clickable.Scrollable;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollable;
/*     */ import util.text.D;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.Key;
/*     */ import view.keyboard.KeyPage;
/*     */ 
/*     */ class ScKeys
/*     */   extends GuiSection {
/*  30 */   final CharSequence ¤¤nameBig = "¤KEY SETTINGS";
/*  31 */   private final CharSequence ¤¤name = "¤key settings";
/*  32 */   private int page = 0;
/*     */   
/*     */   private Key hoveredKey;
/*     */   
/*     */   ScKeys(final IMenu m, Font font, Font small) {
/*  37 */     D.t(this);
/*     */     
/*  39 */     GButt.Glow glow1 = new GButt.Glow(font.getText(D.g("restore")))
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  43 */           KEYS.get().restore();
/*  44 */           KEYS.get().save();
/*     */         }
/*     */       };
/*  47 */     add((RENDEROBJ)glow1);
/*  48 */     GButt.Glow glow2 = new GButt.Glow(font.getText(D.g("cancel")))
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  52 */           m.setMain();
/*     */         }
/*     */       };
/*  55 */     addRightC(100, (RENDEROBJ)glow2);
/*     */     
/*  57 */     GuiSection keys = new GuiSection();
/*     */     
/*  59 */     Scrollable.ScrollRow[] butts = { 
/*  60 */         new Row(), 
/*  61 */         new Row(), 
/*  62 */         new Row(), 
/*  63 */         new Row(), 
/*  64 */         new Row(), 
/*  65 */         new Row(), 
/*  66 */         new Row(), 
/*  67 */         new Row(), 
/*  68 */         new Row(), 
/*  69 */         new Row(), 
/*  70 */         new Row(), 
/*  71 */         new Row(), 
/*  72 */         new Row(), 
/*  73 */         new Row(), 
/*  74 */         new Row(), 
/*  75 */         new Row(), 
/*  76 */         new Row(), 
/*  77 */         new Row() };
/*     */ 
/*     */     
/*  80 */     GScrollable gScrollable = new GScrollable(butts)
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  84 */           return (int)Math.ceil(((KeyPage)KEYS.pages().get(ScKeys.this.page)).all().size() / 2.0D);
/*     */         }
/*     */       };
/*  87 */     keys.add((RENDEROBJ)gScrollable.getView());
/*     */ 
/*     */     
/*  90 */     GuiSection ss = new GuiSection();
/*  91 */     ss.add((RENDEROBJ)new GButt.Glow((SPRITE)(SPRITES.icons()).m.arrow_left)
/*     */         {
/*     */           protected void clickA() {
/*  94 */             ScKeys.this.page--;
/*  95 */             if (ScKeys.this.page < 0)
/*  96 */               ScKeys.this.page += KEYS.pages().size(); 
/*     */           }
/*     */         });
/*  99 */     ss.addRightC(100, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 103 */             text.setFont((UI.FONT()).H2);
/* 104 */             text.add(((KeyPage)KEYS.pages().get(ScKeys.this.page)).name());
/*     */           }
/* 106 */         }).r(DIR.N));
/* 107 */     ss.addRightC(100, (RENDEROBJ)new GButt.Glow((SPRITE)(SPRITES.icons()).m.arrow_right)
/*     */         {
/*     */           protected void clickA() {
/* 110 */             ScKeys.this.page++;
/* 111 */             if (ScKeys.this.page >= KEYS.pages().size()) {
/* 112 */               ScKeys.this.page -= KEYS.pages().size();
/*     */             }
/*     */           }
/*     */         });
/* 116 */     keys.addRelBody(8, DIR.N, (RENDEROBJ)ss);
/*     */ 
/*     */     
/* 119 */     keys.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 123 */             if (ScKeys.this.hoveredKey != null) {
/* 124 */               text.clear().add(ScKeys.this.hoveredKey.desc);
/*     */             }
/*     */           }
/* 127 */         }).r(DIR.N));
/*     */     
/* 129 */     keys.body().incrH(24.0D);
/*     */ 
/*     */     
/* 132 */     keys.add(UI.decor().frame((RECTANGLE)keys.body()));
/*     */     
/* 134 */     addRelBody(32, DIR.N, (RENDEROBJ)keys);
/* 135 */     addRelBody(0, DIR.N, UI.decor().decorate(this.¤¤name));
/*     */     
/* 137 */     body().centerIn(C.DIM());
/*     */   }
/*     */ 
/*     */   
/*     */   public GuiSection activate() {
/* 142 */     this.hoveredKey = null;
/* 143 */     this.page = 0;
/*     */     
/* 145 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 151 */     super.render(r, ds);
/* 152 */     this.hoveredKey = null;
/*     */   }
/*     */   
/*     */   private class Row
/*     */     extends GuiSection implements Scrollable.ScrollRow {
/*     */     private final ScKeys.KeyCode a;
/*     */     private final ScKeys.KeyCode b;
/*     */     
/*     */     Row() {
/* 161 */       this.a = new ScKeys.KeyCode();
/* 162 */       this.b = new ScKeys.KeyCode();
/* 163 */       add((RENDEROBJ)this.a);
/* 164 */       addRightC(20, (RENDEROBJ)this.b);
/*     */     }
/*     */ 
/*     */     
/*     */     public void init(int index) {
/* 169 */       this.a.init(index);
/* 170 */       this.b.init((int)(Math.ceil(((KeyPage)KEYS.pages().get(ScKeys.this.page)).all().size() / 2.0D) + index));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class KeyCode
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private Key key;
/*     */     
/*     */     protected KeyCode() {
/* 181 */       this.body.setWidth(550.0D);
/* 182 */       this.body.setHeight((UI.FONT()).M.height());
/* 183 */       visableSet(false);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 188 */       if (this.key.rebindable) {
/* 189 */         KEYS.bind(this.key);
/*     */       }
/* 191 */       super.clickA();
/*     */     }
/*     */     
/*     */     void init(int i) {
/* 195 */       if (i < ((KeyPage)KEYS.pages().get(ScKeys.this.page)).all().size()) {
/* 196 */         visableSet(true);
/* 197 */         this.key = (Key)((KeyPage)KEYS.pages().get(ScKeys.this.page)).all().get(i);
/*     */       } else {
/* 199 */         visableSet(false);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 205 */       if (super.hover(mCoo)) {
/* 206 */         ScKeys.this.hoveredKey = this.key;
/* 207 */         return true;
/*     */       } 
/* 209 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 216 */       Str.TMP.clear();
/* 217 */       Str.TMP.add(this.key.name);
/*     */       
/* 219 */       isActive &= this.key.rebindable;
/*     */       
/* 221 */       if (!isActive) {
/* 222 */         (GCOLOR.T()).INACTIVE.bind();
/* 223 */       } else if (isHovered && isSelected) {
/* 224 */         (GCOLOR.T()).HOVER_SELECTED.bind();
/* 225 */       } else if (isHovered) {
/* 226 */         (GCOLOR.T()).HOVERED.bind();
/* 227 */       } else if (isSelected) {
/* 228 */         (GCOLOR.T()).SELECTED.bind();
/*     */       } else {
/* 230 */         (GCOLOR.T()).CLICKABLE.bind();
/* 231 */       }  (UI.FONT()).M.render(r, (CharSequence)Str.TMP, body().x1(), body().y1());
/* 232 */       (UI.FONT()).M.render(r, this.key.repr(), body().x1() + 200, body().y1());
/* 233 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\ScKeys.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */