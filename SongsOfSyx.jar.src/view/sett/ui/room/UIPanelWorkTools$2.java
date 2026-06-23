/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategories;
/*     */ import settlement.room.main.employment.RoomEquip;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GAllocator;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
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
/*     */ 
/*     */ class null
/*     */   extends UIPanelUtil.BlueprintList
/*     */ {
/*     */   null(int $anonymous0) {
/*  43 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   RENDEROBJ row(final RoomBlueprintIns<?> bb) {
/*  47 */     if (bb.employment() == null || !work.has(bb.employment())) {
/*  48 */       return null;
/*     */     }
/*     */     
/*  51 */     UIPanelUtil.RoomRow r = new UIPanelUtil.RoomRow((RoomBlueprintImp)bb)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  54 */           super.hoverInfoGet(text);
/*  55 */           GBox b = (GBox)text;
/*  56 */           b.NL(8);
/*     */           
/*  58 */           b.textL(UIPanelWorkTools.¤¤level);
/*  59 */           b.add((SPRITE)GFORMAT.i(b.text(), work.target(bb.employment()).availableMax()));
/*  60 */           b.NL();
/*  61 */           if (work.target(bb.employment()).boost() != null) {
/*  62 */             work.target(bb.employment()).boost().hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(), null, true);
/*     */           }
/*  64 */           b.sep();
/*     */           
/*  66 */           b.textL(Dic.¤¤Boosts);
/*  67 */           b.NL();
/*  68 */           (work.boost(bb.employment())).booster.hover((GUI_BOX)b, work.targetI(bb.employment()) / (work.target(bb.employment()).max() * bb.employment().employed()));
/*  69 */           (work.boost(bb.employment())).booster.hoverSpan((GUI_BOX)b, work.targetI(bb.employment()) / (work.target(bb.employment()).max() * bb.employment().employed()));
/*  70 */           b.NL();
/*     */         }
/*     */       };
/*     */     
/*  74 */     r.addRelBody(8, DIR.E, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  78 */             GFORMAT.i(text, work.targetI(bb.employment()));
/*     */           }
/*     */         });
/*     */     
/*  82 */     r.addRelBody(48, DIR.E, (RENDEROBJ)new GAllocator((COLOR)COLOR.ORANGE100.makeSaturated(0.7D), (INT.INTE)work.target(bb.employment()), 6, 16));
/*  83 */     r.body().incrW((420 - r.body().width()));
/*  84 */     r.pad(16, 0);
/*  85 */     return (RENDEROBJ)r;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addToCat(GuiSection s, final RoomCategories.RoomCategoryMain cat) {
/*  92 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         
/*     */         public void update(GText text)
/*     */         {
/*  97 */           int needed = 0;
/*  98 */           for (RoomBlueprintImp b : cat.all()) {
/*  99 */             if (b.employment() != null)
/* 100 */               needed += work.targetI(b.employment()); 
/*     */           } 
/* 102 */           GFORMAT.i(text, needed);
/*     */         }
/* 104 */       }).r(DIR.W);
/* 105 */     hOVERABLE.body().moveX1(s.body().x1());
/* 106 */     hOVERABLE.body().moveY1(s.getLastY2());
/* 107 */     s.add((RENDEROBJ)hOVERABLE);
/*     */     
/* 109 */     GButt.Glow glow = new GButt.Glow((SPRITE)(SPRITES.icons()).s.magnifier)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 113 */           for (int bi = 0; bi < cat.all().size(); bi++) {
/* 114 */             RoomBlueprintImp b = (RoomBlueprintImp)cat.all().get(bi);
/* 115 */             if (b instanceof RoomBlueprintIns) {
/*     */               
/* 117 */               RoomBlueprintIns<?> bb = (RoomBlueprintIns)b;
/* 118 */               if (bb.employment() != null) {
/* 119 */                 work.target(bb.employment()).inc(1);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 127 */     glow.body().moveX1((s.body().x2() + 32));
/* 128 */     glow.body().moveCY((s.body().cY() - 16));
/* 129 */     s.add((RENDEROBJ)glow);
/*     */     
/* 131 */     glow = new GButt.Glow((SPRITE)(SPRITES.icons()).s.minifier)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 135 */           for (int bi = 0; bi < cat.all().size(); bi++) {
/* 136 */             RoomBlueprintImp b = (RoomBlueprintImp)cat.all().get(bi);
/* 137 */             if (b instanceof RoomBlueprintIns) {
/*     */               
/* 139 */               RoomBlueprintIns<?> bb = (RoomBlueprintIns)b;
/* 140 */               if (bb.employment() != null) {
/* 141 */                 work.target(bb.employment()).inc(-1);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 149 */     s.addDownC(8, (RENDEROBJ)glow);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIPanelWorkTools$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */