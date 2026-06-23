/*     */ package view.ui.manage;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PTech;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.main.VIEW;
/*     */ import view.ui.UIView;
/*     */ 
/*     */ public final class IManager {
/*     */   public static final int TOP_HEIGHT = 48;
/*  42 */   private final GuiSection top = new GuiSection();
/*     */   private IFullView current;
/*  44 */   private final Inter inter = new Inter();
/*     */   
/*     */   public IManager(UIView view) {
/*  47 */     ArrayListGrower<IFullView> all = new ArrayListGrower();
/*  48 */     all.add(view.goods);
/*  49 */     all.add(view.economy);
/*  50 */     all.add(view.tourists);
/*  51 */     all.add(view.tech);
/*  52 */     all.add(view.raider);
/*  53 */     all.add(view.level);
/*  54 */     all.add(view.profile);
/*     */ 
/*     */     
/*  57 */     for (IFullView w : all) {
/*     */       
/*  59 */       GButt.ButtPanel b = new GButt.ButtPanel(w.icon)
/*     */         {
/*     */           protected void clickA() {
/*  62 */             IManager.this.show(w);
/*     */           }
/*     */           
/*     */           protected void renAction() {
/*  66 */             selectedSet((w == IManager.this.current));
/*     */           }
/*     */         };
/*  69 */       b.hoverInfoSet(w.title);
/*  70 */       b.pad(16, 2);
/*  71 */       this.top.addRightC(0, (RENDEROBJ)b);
/*     */     } 
/*     */ 
/*     */     
/*  75 */     this.top.body().centerX(C.DIM());
/*  76 */     GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.exit)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  80 */           IManager.this.inter.hide();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  85 */           text.title(Dic.¤¤Close);
/*     */         }
/*     */       };
/*     */     
/*  89 */     CLICKABLE cLICKABLE = KeyButt.wrap((CLICKABLE)buttPanel, (KEYS.MAIN()).SWAP);
/*  90 */     cLICKABLE.body().moveX2((C.WIDTH() - 8));
/*  91 */     cLICKABLE.body().centerY((BODY_HOLDER)this.top);
/*  92 */     this.top.add((RENDEROBJ)cLICKABLE);
/*     */     
/*  94 */     this.top.body().centerY(0.0D, 48.0D);
/*     */   }
/*     */   
/*     */   public void show(IFullView view) {
/*  98 */     this.current = view;
/*  99 */     this.current.section.body().moveY1(56.0D);
/* 100 */     this.current.section.body().moveX1(16.0D);
/* 101 */     this.current.init();
/* 102 */     this.inter.activate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void show() {
/* 107 */     show((this.current == null) ? (IFullView)(VIEW.UI()).goods : this.current);
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 112 */     this.inter.hide();
/*     */   }
/*     */   
/*     */   public boolean open() {
/* 116 */     return this.inter.isActivated();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Inter
/*     */     extends Interrupter
/*     */   {
/*     */     protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 135 */       IManager.this.current.section.hover(mCoo);
/* 136 */       IManager.this.top.hover(mCoo);
/* 137 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void mouseClick(MButt button) {
/* 142 */       if (button == MButt.RIGHT) {
/* 143 */         if (!IManager.this.current.back())
/* 144 */           hide(); 
/* 145 */       } else if (button == MButt.LEFT) {
/* 146 */         IManager.this.current.section.click();
/* 147 */         IManager.this.top.click();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void hoverTimer(GBox text) {
/* 155 */       IManager.this.current.section.hoverInfoGet((GUI_BOX)text);
/* 156 */       IManager.this.top.hoverInfoGet((GUI_BOX)text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean update(float ds) {
/* 161 */       GAME.SPEED.tmpPause();
/* 162 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean render(Renderer r, float ds) {
/* 168 */       GCOLOR.UI().bg().render((SPRITE_RENDERER)r, C.DIM());
/* 169 */       IManager.this.current.section.render((SPRITE_RENDERER)r, ds);
/*     */       
/* 171 */       (UI.PANEL()).butt.render((SPRITE_RENDERER)r, 0, C.WIDTH(), 0, 48, 0, DIR.S.mask());
/* 172 */       IManager.this.top.render((SPRITE_RENDERER)r, ds);
/* 173 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hide() {
/* 179 */       super.hide();
/*     */     }
/*     */     
/*     */     public void activate() {
/* 183 */       show((VIEW.inters()).manager);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CLICKABLE butt() {
/* 190 */     GuiSection s = new GuiSection();
/* 191 */     int i = 0;
/*     */     
/* 193 */     bAdd(s, i++, (IFullView)(VIEW.UI()).goods, (SPRITE)(UI.icons()).s.storage, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 197 */             GFORMAT.perc(text, ((SETT.ROOMS()).STOCKPILE.tally().amountTotal(null) + 1.0D) / (((SETT.ROOMS()).STOCKPILE.tally()).space.total(null) + 1.0D), 0);
/*     */           }
/*     */         });
/*     */     
/* 201 */     bAdd(s, i++, (IFullView)(VIEW.UI()).economy, (SPRITE)(UI.icons()).s.money, (SPRITE)new GStat()
/*     */         {
/* 203 */           int ri = 0;
/* 204 */           int prob = 0;
/* 205 */           int probL = 0;
/*     */ 
/*     */           
/*     */           public void update(GText text) {
/* 209 */             if ((GAME.updateI() & 0x11) == 0) {
/* 210 */               if (this.ri >= TR.ALL().size()) {
/* 211 */                 this.probL = this.prob;
/* 212 */                 this.prob = 0;
/* 213 */                 this.ri = 0;
/*     */               } else {
/* 215 */                 TRADABLE res = (TRADABLE)TR.ALL().get(this.ri);
/*     */                 
/* 217 */                 if (this.prob < 2) {
/* 218 */                   if (FACTIONS.player().buyer(res).importing() && FACTIONS.player().buyer(res).problem() != null)
/* 219 */                     this.prob = 2; 
/* 220 */                   if (FACTIONS.player().seller(res).exporting() == null && FACTIONS.player().seller(res).problem() != null) {
/* 221 */                     this.prob = 2;
/*     */                   }
/*     */                 } 
/* 224 */                 if (this.prob < 1) {
/* 225 */                   if (FACTIONS.player().buyer(res).importing() && FACTIONS.player().buyer(res).warning() != null)
/* 226 */                     this.prob = 1; 
/* 227 */                   if (FACTIONS.player().seller(res).exporting() == null && FACTIONS.player().seller(res).warning() != null)
/* 228 */                     this.prob = 1; 
/*     */                 } 
/* 230 */                 this.ri++;
/*     */               } 
/*     */             }
/*     */ 
/*     */ 
/*     */             
/* 236 */             GFORMAT.i(text, (int)FACTIONS.player().credits().credits());
/*     */             
/* 238 */             if (this.probL == 0) {
/* 239 */               text.normalify();
/* 240 */             } else if (this.probL == 1) {
/* 241 */               text.warnify();
/*     */             } else {
/* 243 */               text.errorify();
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 248 */     bAdd(s, i++, (IFullView)(VIEW.UI()).tourists, (SPRITE)(UI.icons()).s.camera, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 252 */             GFORMAT.i(text, STATS.POP().pop(HTYPES.TOURIST()));
/*     */           }
/*     */         });
/*     */     
/* 256 */     bAdd(s, i++, (IFullView)(VIEW.UI()).tech, (SPRITE)(UI.icons()).s.vial, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 260 */             int am = 0;
/* 261 */             for (PTech.TechCurr c : (GAME.player()).tech.currs())
/* 262 */               am += c.available(); 
/* 263 */             GFORMAT.i(text, am);
/*     */           }
/*     */         });
/*     */     
/* 267 */     bAdd(s, i++, (IFullView)(VIEW.UI()).raider, (SPRITE)(UI.icons()).s.death, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 271 */             GFORMAT.i(text, GAME.raiders().active().size());
/* 272 */             text.errorify();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 277 */     GuiSection ss = new GuiSection();
/* 278 */     ss.addRight(0, (RENDEROBJ)bb((IFullView)(VIEW.UI()).level, (SPRITE)(UI.icons()).s.arrowUp, null));
/* 279 */     ss.addRight(0, (RENDEROBJ)bb((IFullView)(VIEW.UI()).profile, (SPRITE)(UI.icons()).s.menu, null));
/* 280 */     bAdd(s, i++, (RENDEROBJ)ss);
/*     */ 
/*     */ 
/*     */     
/* 284 */     return (CLICKABLE)s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void bAdd(GuiSection s, int i, IFullView v, SPRITE icon, SPRITE vv) {
/* 290 */     CLICKABLE p = bb(v, icon, vv);
/* 291 */     bAdd(s, i, (RENDEROBJ)p);
/*     */   }
/*     */ 
/*     */   
/*     */   private CLICKABLE bb(final IFullView v, final SPRITE icon, final SPRITE vv) {
/* 296 */     CLICKABLE.ClickableAbs clickableAbs = new CLICKABLE.ClickableAbs(74 / ((vv == null) ? 2 : 1), 24)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 300 */           GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 301 */           GButt.ButtPanel.renderFrame(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*     */           
/* 303 */           if (vv == null) {
/* 304 */             icon.renderC(r, this.body.cX(), this.body.cY());
/*     */           } else {
/* 306 */             icon.renderCY(r, this.body.x1() + 4, this.body.cY());
/*     */             
/* 308 */             vv.renderCY(r, this.body.x1() + 20, this.body.cY());
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 317 */           IManager.this.show(v);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 322 */           v.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/* 326 */     clickableAbs.hoverInfoSet(v.title);
/* 327 */     return (CLICKABLE)clickableAbs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void bAdd(GuiSection s, int i, RENDEROBJ ren) {
/* 333 */     s.add(ren, i / 2 * 74, 24 * i % 2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\manage\IManager.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */