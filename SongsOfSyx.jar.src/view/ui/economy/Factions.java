/*     */ package view.ui.economy;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.faction.trade.TradeManager;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class Factions extends GuiSection {
/*  29 */   private ArrayList<FactionNPC> all = new ArrayList(FACTIONS.MAX());
/*     */   private static final int width = 96;
/*  31 */   private final GText t = new GText((UI.FONT()).S, 16);
/*     */ 
/*     */   
/*     */   Factions(int HEIGHT) {
/*  35 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  39 */           return Factions.this.all.size();
/*     */         }
/*     */       };
/*     */     
/*  43 */     bu.column("", 96, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  47 */             return (RENDEROBJ)new Factions.Row(ier);
/*     */           }
/*     */         });
/*     */     
/*  51 */     add((RENDEROBJ)bu.createHeight(48 * HEIGHT / 48, false));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  57 */     this.all.clearSloppy();
/*  58 */     for (FactionNPC f : FACTIONS.NPCs()) {
/*  59 */       if (RD.DIST().reachable((Faction)f)) {
/*  60 */         this.all.add(f);
/*     */       }
/*     */     } 
/*  63 */     for (FactionNPC f : FACTIONS.NPCs()) {
/*  64 */       if (!RD.DIST().reachable((Faction)f)) {
/*  65 */         this.all.add(f);
/*     */       }
/*     */     } 
/*     */     
/*  69 */     super.render(r, ds);
/*     */   }
/*     */   
/*     */   private class Row
/*     */     extends CLICKABLE.ClickableAbs {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     Row(GETTER<Integer> ier) {
/*  77 */       this.ier = ier;
/*  78 */       this.body.setDim(96.0D, 48.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  84 */       GButt.ButtPanel.renderBG(r, RD.DIST().reachable((Faction)f()), (DIP.get(f())).trades, isHovered, (RECTANGLE)this.body);
/*     */       
/*  86 */       (f().banner()).BIG.renderCY(r, this.body.x1() + 8, this.body.cY());
/*     */       
/*  88 */       Factions.this.t.clear();
/*  89 */       GFORMAT.percInv(Factions.this.t, ROPINION.tradeCost(f()));
/*     */       
/*  91 */       Factions.this.t.render(r, body().x2() - 48, this.body.y1() + 8);
/*     */       
/*  93 */       Factions.this.t.clear();
/*  94 */       GFORMAT.i(Factions.this.t, Math.round(TradeManager.toll(f())));
/*     */       
/*  96 */       Factions.this.t.render(r, body().x2() - 48, this.body.y1() + 8 + 18);
/*     */       
/*  98 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */       
/* 100 */       if (!RD.DIST().reachable((Faction)f())) {
/* 101 */         OPACITY.O50.bind();
/* 102 */         COLOR.BLACK.render(r, (RECTANGLE)this.body, -1);
/* 103 */         OPACITY.unbind();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     FactionNPC f() {
/* 109 */       return (FactionNPC)Factions.this.all.get(((Integer)this.ier.get()).intValue());
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 114 */       (VIEW.world()).UI.factions.hover(text, (Faction)f());
/* 115 */       GBox b = (GBox)text;
/* 116 */       b.sep();
/*     */       
/* 118 */       b.add((SPRITE)(UI.icons()).s.wheel);
/* 119 */       b.textLL(Dic.¤¤Toll);
/* 120 */       b.tab(7);
/* 121 */       b.add((SPRITE)GFORMAT.f(b.text(), TradeManager.toll(f())));
/* 122 */       b.NL();
/*     */       
/* 124 */       b.add((SPRITE)(UI.icons()).s.money);
/* 125 */       b.textLL(Dic.¤¤CreditScore);
/* 126 */       b.tab(7);
/* 127 */       b.add((SPRITE)GFORMAT.percInc(b.text(), (f()).stockpile.creditScore() - 1.0D));
/* 128 */       b.NL();
/*     */       
/* 130 */       b.add((SPRITE)(UI.icons()).s.angry);
/* 131 */       b.textLL(Dic.¤¤Tariff);
/* 132 */       b.tab(7);
/* 133 */       b.add((SPRITE)GFORMAT.percInv(b.text(), ROPINION.tradeCost(f())));
/* 134 */       b.NL();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 139 */       (VIEW.UI()).manager.close();
/* 140 */       (VIEW.world()).UI.factions.open(f());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\Factions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */