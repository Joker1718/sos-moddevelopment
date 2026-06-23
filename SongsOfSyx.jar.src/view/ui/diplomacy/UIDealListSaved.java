/*     */ package view.ui.diplomacy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.deal.DealBool;
/*     */ import game.faction.diplomacy.deal.DealSave;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.util.LinkedList;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public class UIDealListSaved extends GuiSection {
/*  32 */   private static CharSequence ¤¤YouGet = "We Give you";
/*  33 */   private static CharSequence ¤¤FactionGets = "You give us";
/*     */   
/*     */   static {
/*  36 */     D.ts(UIDealListSaved.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public UIDealListSaved(DealSave deal, int height) {
/*  41 */     LinkedList<RENDEROBJ> rowsp = new LinkedList<>();
/*  42 */     LinkedList<RENDEROBJ> rowsnpc = new LinkedList<>();
/*     */     
/*  44 */     for (int i = 0; i < deal.bools.length; i++) {
/*  45 */       if (deal.bools[i]) {
/*  46 */         rowsp.add(bool((DealBool)(DIP.TMP()).bools.all().get(i)));
/*  47 */         rowsnpc.add(bool((DealBool)(DIP.TMP()).bools.all().get(i)));
/*     */       } 
/*     */     } 
/*     */     
/*  51 */     party(rowsp, deal.player, (Faction)FACTIONS.player());
/*  52 */     party(rowsnpc, deal.npc, (Faction)deal.f());
/*     */     
/*  54 */     LinkedList<RENDEROBJ> rows = new LinkedList<>();
/*     */     
/*  56 */     if (rowsnpc.size() != 0) {
/*  57 */       rows.add(row((RENDEROBJ)new GHeader(¤¤YouGet)));
/*  58 */       for (RENDEROBJ o : rowsnpc) {
/*  59 */         rows.add(row(o));
/*     */       }
/*     */     } 
/*  62 */     if (rowsp.size() != 0) {
/*  63 */       rows.add(new GHeader(¤¤FactionGets));
/*  64 */       for (RENDEROBJ o : rowsp) {
/*  65 */         rows.add(row(o));
/*     */       }
/*     */     } 
/*  68 */     add((RENDEROBJ)(new GScrollRows(rows, height)).view());
/*     */   }
/*     */ 
/*     */   
/*     */   private RENDEROBJ row(final RENDEROBJ o) {
/*  73 */     return (RENDEROBJ)new HOVERABLE.HoverableAbs(400, 32)
/*     */       {
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/*  78 */           o.body().moveX1Y1((RECTANGLE)this.body);
/*  79 */           o.body().moveCY(this.body.cY());
/*  80 */           o.render(r, ds);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  85 */           if (o instanceof HOVERABLE) {
/*  86 */             ((HOVERABLE)o).hoverInfoGet(text);
/*     */           }
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private void party(LinkedList<RENDEROBJ> rows, final DealSave.Party p, final Faction f) {
/*  94 */     if (p.creditsP != 0)
/*  95 */       rows.add((new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  99 */               GFORMAT.i(text, p.creditsP);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GBox b) {
/* 104 */               b.title(Dic.¤¤Currs);
/*     */             }
/* 107 */           }).hh((SPRITE)(UI.icons()).s.money));  byte b;
/*     */     int i;
/*     */     int[] arrayOfInt;
/* 110 */     for (i = (arrayOfInt = p.regsP).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/*     */       
/* 112 */       if (j >= 0 && WORLD.REGIONS().getByIndex(j).active()) {
/* 113 */         final Region reg = WORLD.REGIONS().getByIndex(j);
/* 114 */         rows.add((new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 118 */                 text.add((CharSequence)reg.info.name());
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GBox b) {
/* 123 */                 b.title((CharSequence)reg.info.name());
/*     */               }
/* 126 */             }).hh((SPRITE)(UI.icons()).s.world));
/*     */       } 
/*     */       b++; }
/*     */     
/* 130 */     for (TRADABLE res : TR.ALL()) {
/* 131 */       if (p.resP[res.index()] != 0) {
/* 132 */         rows.add((new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 136 */                 GFORMAT.i(text, p.resP[res.index()]);
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GBox b) {
/* 141 */                 b.title(res.names);
/*     */                 
/* 143 */                 if (f != null) {
/* 144 */                   b.textLL(Dic.¤¤Available);
/* 145 */                   b.add((SPRITE)GFORMAT.i(b.text(), f.res().getAvailable(res)));
/*     */                 
/*     */                 }
/*     */               
/*     */               }
/* 150 */             }).hh(res.icon()));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static RENDEROBJ bool(DealBool bo) {
/* 158 */     GText t = new GText((UI.FONT()).M, bo.info.name);
/* 159 */     GTextR tt = new GTextR(t);
/* 160 */     tt.hoverInfoSet(bo.info.desc);
/* 161 */     return (RENDEROBJ)tt;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDealListSaved.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */