/*     */ package view.ui.economy;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FWorth;
/*     */ import game.faction.player.PCredits;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ final class MainDetails extends GuiSection {
/*  26 */   private final GText t = (new GText((UI.FONT()).S, 48)).lablify();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   MainDetails(final INT.IntImp ii) {
/*  32 */     int i = 0;
/*     */     
/*  34 */     for (PCredits.CredHistory h : GAME.player().credits().all()) {
/*  35 */       HOVERABLE hh = (new HOVERABLE.Sprite(new SDetail(this, h)
/*     */           {
/*     */             void up(GText text)
/*     */             {
/*  39 */               int i = ii.get();
/*  40 */               if (i < 0)
/*  41 */                 i = GAME.player().credits().creditsH().historyRecords() - 1; 
/*  42 */               i = GAME.player().credits().creditsH().historyRecords() - i - 1;
/*  43 */               GFORMAT.iIncr(text, (h.IN.get(i) - h.OUT.get(i)));
/*     */             }
/*  45 */           })).hoverTitleSet(h.type.name).hoverInfoSet(h.type.desc);
/*     */       
/*  47 */       hh.body().moveX1Y1((i % 1 * (hh.body().width() + 32)), (i / 1 * (hh.body().height() + 2)));
/*  48 */       add((RENDEROBJ)hh);
/*  49 */       i++;
/*     */     } 
/*     */     
/*  52 */     addDown(0, (RENDEROBJ)new HOVERABLE.HoverableAbs(260, 32) {
/*  53 */           GText t = (new GText((UI.FONT()).S, 48)).lablify();
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  56 */             (GCOLOR.T()).H1.bind();
/*  57 */             (UI.FONT()).H2.renderCY(r, body().x1() + (UI.FONT()).S.height() * 2, body().cY(), Dic.¤¤Treasury);
/*  58 */             this.t.clear();
/*  59 */             int i = ii.get();
/*  60 */             if (i < 0)
/*  61 */               i = GAME.player().credits().creditsH().historyRecords() - 1; 
/*  62 */             i = GAME.player().credits().creditsH().historyRecords() - i - 1;
/*  63 */             GFORMAT.i(this.t, FACTIONS.player().credits().creditsH().get(i));
/*  64 */             this.t.adjustWidth();
/*  65 */             this.t.renderCY(r, body().x2() - this.t.width(), body().cY());
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  70 */     addDown(0, (RENDEROBJ)new HOVERABLE.HoverableAbs(260, 32) {
/*  71 */           GText t = (new GText((UI.FONT()).S, 48)).lablify();
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  74 */             (GCOLOR.T()).H1.bind();
/*  75 */             (UI.FONT()).H2.renderCY(r, body().x1() + (UI.FONT()).S.height() * 2, body().cY(), Dic.¤¤NetWorth);
/*  76 */             this.t.clear();
/*  77 */             int i = ii.get();
/*  78 */             if (i < 0)
/*  79 */               i = (GAME.player().credits()).worth.historyRecords() - 1; 
/*  80 */             i = GAME.player().credits().creditsH().historyRecords() - i - 1;
/*  81 */             GFORMAT.i(this.t, (FACTIONS.player().credits()).worth.get(i));
/*  82 */             this.t.adjustWidth();
/*  83 */             this.t.renderCY(r, body().x2() - this.t.width(), body().cY());
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  89 */             GBox b = (GBox)text;
/*  90 */             for (FWorth.WINT d : (FACTIONS.WORTH()).faction) {
/*  91 */               b.add(d.icon);
/*  92 */               b.textL(d.info.name);
/*  93 */               b.tab(6);
/*  94 */               b.add((SPRITE)GFORMAT.iIncr(b.text(), d.player()));
/*  95 */               b.NL();
/*  96 */               b.text(d.info.desc);
/*  97 */               b.NL(5);
/*     */             } 
/*  99 */             super.hoverInfoGet(text);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private abstract class SDetail
/*     */     implements SPRITE
/*     */   {
/* 110 */     private final GStat stat = new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 114 */           MainDetails.SDetail.this.up(text);
/*     */         }
/*     */       };
/*     */     
/*     */     private final PCredits.CredHistory cr;
/*     */     
/*     */     SDetail(PCredits.CredHistory cr) {
/* 121 */       this.cr = cr;
/*     */     }
/*     */ 
/*     */     
/*     */     abstract void up(GText param1GText);
/*     */     
/*     */     public int width() {
/* 128 */       return 260;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int height() {
/* 135 */       return this.stat.height();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 142 */       ColorImp.TMP.set((COLOR)COLOR.UNIQUE.getC(this.cr.type.ordinal())).shadeSelf(0.5D);
/* 143 */       ColorImp.TMP.render(r, X1, X1 + height(), Y1, Y1 + height());
/* 144 */       ColorImp.TMP.set((COLOR)COLOR.UNIQUE.getC(this.cr.type.ordinal()));
/* 145 */       ColorImp.TMP.render(r, X1 + 2, X1 + height() - 2, Y1 + 2, Y1 + height() - 2);
/*     */       
/* 147 */       MainDetails.this.t.clear().add(this.cr.type.name);
/*     */       
/* 149 */       MainDetails.this.t.render(r, X1 + height() * 2, Y1);
/*     */       
/* 151 */       this.stat.adjust();
/*     */       
/* 153 */       this.stat.render(r, X2 - this.stat.width(), Y1);
/*     */     }
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\MainDetails.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */