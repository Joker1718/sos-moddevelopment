/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.raiding.RaidingMap;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.interrupter.ISidePanels;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.RDOutputs;
/*     */ 
/*     */ 
/*     */ final class ListPlayer
/*     */   extends ISidePanel
/*     */ {
/*     */   ListPlayer(final ISidePanels panels) {
/*  36 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  40 */           return FACTIONS.player().realm().regions() - 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfo(int index, GBox box) {
/*  45 */           Region reg = FACTIONS.player().realm().region(index + 1);
/*  46 */           (VIEW.world()).UI.regions.hover(reg, (GUI_BOX)box);
/*     */         }
/*     */ 
/*     */         
/*     */         public void click(int index) {
/*  51 */           Region reg = FACTIONS.player().realm().region(index + 1);
/*  52 */           (VIEW.world()).window.centererTile.set(reg.cx(), reg.cy());
/*  53 */           ISidePanel p = (VIEW.world()).UI.regions.get(reg);
/*  54 */           panels.add(ListPlayer.this, true);
/*  55 */           panels.add(p, false);
/*  56 */           super.click(index);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean selectedIs(int index) {
/*  61 */           Region reg = FACTIONS.player().realm().region(index + 1);
/*  62 */           return (VIEW.world()).UI.regions.active(reg);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     bu.column(Dic.¤¤name, 120, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/*  73 */             return (RENDEROBJ)(new GStat((UI.FONT()).S)
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/*  77 */                   text.setMaxWidth(110);
/*  78 */                   text.setMultipleLines(false);
/*  79 */                   text.lablify().add((CharSequence)(ListPlayer.reg(ier)).info.name());
/*     */                 }
/*  81 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/*  85 */     HOVERABLE title = (new HOVERABLE.Sprite((SPRITE)(UI.icons()).s.human)).hoverTitleSet(Dic.¤¤Population);
/*  86 */     bu.column(title, 80, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/*  90 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/*  94 */                   GFORMAT.i(text, (RD.RACES()).population.get(ListPlayer.reg(ier)));
/*     */                 }
/*  96 */               }).r(DIR.E);
/*     */           }
/*  98 */         }DIR.E);
/*     */     
/* 100 */     title = (new HOVERABLE.Sprite((SPRITE)(UI.icons()).s.happy)).hoverTitleSet(((RD.RACES()).loyaltyAll.info()).name);
/* 101 */     bu.column(title, 48, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 105 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 109 */                   GFORMAT.perc(text, (RD.RACES()).loyaltyAll.getD(ListPlayer.reg(ier)));
/*     */                 }
/* 111 */               }).r(DIR.E);
/*     */           }
/* 113 */         }DIR.E);
/*     */     
/* 115 */     title = (new HOVERABLE.Sprite((SPRITE)(UI.icons()).s.heart)).hoverTitleSet((RD.HEALTH()).name);
/* 116 */     bu.column(title, 48, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 120 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 124 */                   GFORMAT.perc(text, RD.HEALTH().getD(ListPlayer.reg(ier)));
/*     */                 }
/* 126 */               }).r(DIR.E);
/*     */           }
/* 128 */         }DIR.E);
/*     */     
/* 130 */     title = (new HOVERABLE.Sprite((SPRITE)(UI.icons()).s.shield)).hoverTitleSet(RaidingMap.¤¤Name);
/* 131 */     bu.column(title, 48, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 135 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 139 */                   GFORMAT.perc(text, CLAMP.d((GAME.raiders()).entry.get(ListPlayer.reg(ier)).security(), -1.0D, 1.0D));
/*     */                 }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {}
/* 147 */               }).r(DIR.E);
/*     */           }
/* 149 */         }DIR.E);
/*     */     
/* 151 */     title = (new HOVERABLE.Sprite((SPRITE)(UI.icons()).s.arrow_left)).hoverTitleSet(FResources.RTYPE.TAX.name);
/* 152 */     bu.column(title, 160, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 157 */             return (RENDEROBJ)new RENDEROBJ.RenderImp(120, 32)
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, float ds)
/*     */                 {
/* 161 */                   int i = 0;
/* 162 */                   int dy = 0;
/* 163 */                   for (RDOutputs.RDOutput res : (RD.OUTPUT()).ALL) {
/* 164 */                     if (res.getDelivery(ListPlayer.reg(ier)) > 0) {
/* 165 */                       res.boost.icon.render(r, this.body.x1() + i * 16, this.body.y1() + dy * 16 * dy);
/* 166 */                       i += dy;
/* 167 */                       dy++;
/* 168 */                       dy &= 0x1;
/* 169 */                       if (i >= 10)
/*     */                         break; 
/*     */                     } 
/*     */                   } 
/*     */                 }
/*     */               };
/*     */           }
/* 176 */         }DIR.E);
/*     */ 
/*     */     
/* 179 */     this.section.add((RENDEROBJ)bu.createHeight(HEIGHT - 64, true));
/*     */     
/* 181 */     this.section.addDownC(8, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤All)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 185 */             (VIEW.world()).UI.regions.openOtherList();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     titleSet(Dic.¤¤Realm);
/*     */   }
/*     */   
/*     */   private static Region reg(GETTER<Integer> ier) {
/* 197 */     return FACTIONS.player().realm().region(((Integer)ier.get()).intValue() + 1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\ListPlayer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */