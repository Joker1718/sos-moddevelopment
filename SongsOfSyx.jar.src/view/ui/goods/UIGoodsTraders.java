/*     */ package view.ui.goods;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.region.RD;
/*     */ 
/*     */ public abstract class UIGoodsTraders extends GuiSection {
/*  30 */   private GText buttPrice = new GText((UI.FONT()).S, 64);
/*  31 */   private final FactionNPC[] facs = new FactionNPC[FACTIONS.MAX()];
/*  32 */   private int max = 0;
/*     */   
/*  34 */   private static CharSequence ¤¤TradeYes = "¤You have a trade agreement with this faction, and trade is possible.";
/*  35 */   private static CharSequence ¤¤TradeNo = "¤You do not have a trade agreement with this faction. Trade is not possible.";
/*  36 */   private static CharSequence ¤¤Click = "¤Click to go to the diplomacy screen for this faction."; private final Comparator<FactionNPC> comp;
/*     */   
/*     */   static {
/*  39 */     D.ts(UIGoodsTraders.class);
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
/*     */   private class Butt
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final GETTER<Integer> ier;
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
/*     */     Butt(GETTER<Integer> ier) {
/*  70 */       this.body.setDim(96.0D, 32.0D);
/*  71 */       this.ier = ier;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  77 */       FactionNPC f = UIGoodsTraders.this.facs[((Integer)this.ier.get()).intValue()];
/*     */       
/*  79 */       isSelected |= (DIP.get(f)).trades;
/*     */       
/*  81 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*  82 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */       
/*  84 */       (f.banner()).MEDIUM.renderCY(r, this.body.x1() + 4, this.body.cY());
/*     */       
/*  86 */       UIGoodsTraders.this.buttPrice.clear();
/*  87 */       GFORMAT.i(UIGoodsTraders.this.buttPrice, UIGoodsTraders.this.price(f));
/*  88 */       UIGoodsTraders.this.buttPrice.adjustWidth();
/*     */       
/*  90 */       UIGoodsTraders.this.buttPrice.renderCY(r, this.body.x1() + 4 + 24 + 4, this.body.cY());
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/*  95 */       FactionNPC f = UIGoodsTraders.this.facs[((Integer)this.ier.get()).intValue()];
/*  96 */       (VIEW.world()).UI.factions.hover(text, (Faction)f);
/*  97 */       GBox b = (GBox)text;
/*     */       
/*  99 */       b.sep();
/*     */       
/* 101 */       b.textLL(Dic.¤¤Price);
/* 102 */       b.tab(6).add((SPRITE)GFORMAT.i(b.text(), UIGoodsTraders.this.price(f)));
/* 103 */       b.NL(8);
/* 104 */       if ((DIP.get(f)).trades) {
/* 105 */         b.text(UIGoodsTraders.¤¤TradeYes);
/*     */       } else {
/* 107 */         b.text(UIGoodsTraders.¤¤TradeNo);
/* 108 */       }  b.NL(4);
/* 109 */       b.text(UIGoodsTraders.¤¤Click);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 114 */       FactionNPC f = UIGoodsTraders.this.facs[((Integer)this.ier.get()).intValue()];
/* 115 */       if (!(DIP.get(f)).trades && ROPINION.get(f) >= (DIP.TRADE()).opinionNeeded) {
/* 116 */         (VIEW.world()).UI.factions.openTrade(f);
/*     */       } else {
/* 118 */         (VIEW.world()).UI.factions.openDip(f);
/* 119 */       }  (VIEW.UI()).manager.close();
/*     */     }
/*     */   }
/*     */   
/*     */   public UIGoodsTraders(int hi)
/*     */   {
/* 125 */     this.comp = new Comparator<FactionNPC>()
/*     */       {
/*     */         public int compare(FactionNPC o1, FactionNPC o2)
/*     */         {
/* 129 */           return UIGoodsTraders.this.sortValue(o1) - UIGoodsTraders.this.sortValue(o2); }
/*     */       };
/*     */     GTableBuilder bu = new GTableBuilder() {
/*     */         public int nrOFEntries() { return UIGoodsTraders.this.max; }
/*     */       };
/*     */     bu.column(null, (new Butt(null)).body().width(), new GTableBuilder.GRowBuilder() { public RENDEROBJ build(GETTER<Integer> ier) { return (RENDEROBJ)new UIGoodsTraders.Butt(ier); } }
/*     */       );
/*     */     add((RENDEROBJ)bu.create(hi, false));
/*     */   } public void render(SPRITE_RENDERER r, float ds) {
/* 138 */     this.max = 0;
/*     */     
/* 140 */     for (FactionNPC f : RD.DIST().neighs()) {
/* 141 */       if (price(f) > 0) {
/* 142 */         this.facs[this.max++] = f;
/*     */       }
/*     */     } 
/*     */     
/* 146 */     Arrays.sort(this.facs, 0, this.max, this.comp);
/*     */ 
/*     */     
/* 149 */     super.render(r, ds);
/*     */   }
/*     */   
/*     */   protected abstract int price(FactionNPC paramFactionNPC);
/*     */   
/*     */   protected abstract int sortValue(FactionNPC paramFactionNPC);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoodsTraders.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */