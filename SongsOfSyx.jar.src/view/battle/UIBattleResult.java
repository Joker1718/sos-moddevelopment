/*     */ package view.battle;
/*     */ import game.GAME;
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public abstract class UIBattleResult extends GuiSection {
/*  29 */   private static CharSequence ¤¤casulties = "Casualties";
/*  30 */   private static CharSequence ¤¤kills = "Enemy Kills";
/*     */   
/*     */   static {
/*  33 */     D.ts(UIBattleResult.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UIBattleResult(CharSequence title) {
/*  40 */     add(side(GAME.ARMIES().player()));
/*  41 */     addRelBody(8, DIR.E, side(GAME.ARMIES().enemy()));
/*     */     
/*  43 */     final GText tt = (new GText((UI.FONT()).H1, title)).lablify();
/*  44 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(tt.width(), ((UI.PANEL()).titleBoxes[(UI.PANEL()).titleBoxes.length - 1]).height)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  48 */           (UI.PANEL()).titleBoxes[(UI.PANEL()).titleBoxes.length - 1].renderCY(r, this.body.x1(), this.body.cY(), body().width());
/*  49 */           tt.renderC(r, (RECTANGLE)this.body);
/*     */         }
/*     */       };
/*  52 */     addRelBody(16, DIR.N, (RENDEROBJ)renderImp);
/*     */     
/*  54 */     GuiSection s = new GuiSection();
/*     */     
/*  56 */     s.addRightC(0, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Close)
/*     */         {
/*     */           protected void clickA() {
/*  59 */             UIBattleResult.this.close();
/*     */           }
/*     */         });
/*  62 */     s.addRightC(0, (RENDEROBJ)new GButt.ButtPanel(BattlePanel.¤¤restart)
/*     */         {
/*     */           protected void clickA() {
/*  65 */             VIEW.b().state().reloadBattle();
/*     */           }
/*     */         });
/*  68 */     addRelBody(16, DIR.S, (RENDEROBJ)s);
/*     */     
/*  70 */     add((RENDEROBJ)new GPanel((RECTANGLE)body()));
/*  71 */     moveLastToBack();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ side(Army army) {
/*  81 */     GRows rr = new GRows(8);
/*     */     
/*  83 */     int deaths = 0;
/*  84 */     for (Div div : army.divisions()) {
/*     */       
/*  86 */       if (div.info.men() <= 0) {
/*     */         continue;
/*     */       }
/*  89 */       deaths += div.info.men() - div.menNrOf();
/*  90 */       rr.add((RENDEROBJ)new Card(div));
/*     */     } 
/*  92 */     GuiSection s = new GuiSection();
/*  93 */     final int dd = deaths;
/*  94 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  98 */             GFORMAT.i(text, dd);
/*     */           }
/* 100 */         }).hh((SPRITE)(UI.icons()).s.death));
/*     */     
/* 102 */     s.addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)rr.rowsCentered((VIEW.UI()).div.normal.width() * 8), (new Card(GAME.ARMIES().division((short)0))).body().height() * 6)).view());
/* 103 */     return (RENDEROBJ)s;
/*     */   }
/*     */   
/*     */   protected abstract void close();
/*     */   
/*     */   private static class Card
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     int kills;
/*     */     private final Div div;
/*     */     
/*     */     Card(Div div) {
/* 115 */       this.body.setDim((VIEW.UI()).div.normal.width(), ((VIEW.UI()).div.normal.height() + 8));
/* 116 */       this.div = div;
/* 117 */       this.kills = (GAME.ARMIES()).factors.kills(div);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 122 */       GButt.ButtPanel.renderBG(r, true, false, isHovered, (RECTANGLE)this.body);
/*     */       
/* 124 */       (VIEW.UI()).div.renderBasics(r, this.body.x1(), this.body.y1(), 1, (DIV_SPEC)this.div.info);
/*     */       
/* 126 */       double menTot = this.div.info.men();
/* 127 */       double menNow = this.div.menNrOf();
/*     */       
/* 129 */       GMeter.renderDelta(r, 1.0D, menNow / menTot, this.body.x1(), this.body.x2(), this.body.y2() - 12, this.body.y2());
/*     */       
/* 131 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 136 */       GBox b = (GBox)text;
/* 137 */       int menTot = this.div.info.men();
/* 138 */       int menNow = this.div.menNrOf();
/*     */       
/* 140 */       b.title((CharSequence)this.div.info.name());
/* 141 */       b.textLL(UIBattleResult.¤¤casulties);
/* 142 */       b.tab(6);
/* 143 */       b.add((SPRITE)GFORMAT.iofk(b.text(), (menTot - menNow), menTot));
/* 144 */       b.NL();
/* 145 */       b.textLL(UIBattleResult.¤¤kills);
/* 146 */       b.tab(6);
/* 147 */       b.add((SPRITE)GFORMAT.i(b.text(), this.kills));
/*     */       
/* 149 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\UIBattleResult.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */