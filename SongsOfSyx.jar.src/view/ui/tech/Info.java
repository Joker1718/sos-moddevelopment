/*     */ package view.ui.tech;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PTech;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Comparator;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.admin.AdminData;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Info
/*     */   extends GuiSection
/*     */ {
/*     */   Info(UITechTree tree, int width) {
/*  41 */     int wi = width;
/*     */     
/*  43 */     ArrayList<PTech.TechCurr> aa = new ArrayList((Iterable)FACTIONS.player().tech().currs());
/*  44 */     aa.sort(new Comparator<PTech.TechCurr>()
/*     */         {
/*     */           public int compare(PTech.TechCurr o1, PTech.TechCurr o2)
/*     */           {
/*  48 */             return o1.cu.bo.key.compareTo(o2.cu.bo.key);
/*     */           }
/*     */         });
/*  51 */     for (PTech.TechCurr c : FACTIONS.player().tech().currs()) {
/*     */       
/*  53 */       GuiSection guiSection = curr(c);
/*  54 */       if (getLastX2() + guiSection.body().width() > wi) {
/*  55 */         add((RENDEROBJ)guiSection, 0, body().y2()); continue;
/*     */       } 
/*  57 */       addRight(0, (RENDEROBJ)guiSection);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  62 */     if ((S.get()).developer) {
/*  63 */       addRight(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.questionmark)
/*     */           {
/*     */             protected void clickA() {
/*  66 */               (VIEW.inters()).popup.show((RENDEROBJ)TechTest.get(), (CLICKABLE)this);
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  75 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static GuiSection curr(final PTech.TechCurr c) {
/*  82 */     GuiSection res = new GuiSection();
/*     */     
/*  84 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         protected void hoverInfoSelf(GUI_BOX box)
/*     */         {
/*  88 */           c.hover(box);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  93 */     s.add((SPRITE)(UI.icons()).s.dot.createColored((COLOR)Node.cols.get(c.cu.index)), 0, 0);
/*     */     
/*  95 */     s.addRightC(4, (SPRITE)c.cu.bo.icon);
/*  96 */     s.addRightC(4, (RENDEROBJ)new GHeader(c.cu.bo.name));
/*  97 */     s.addRightC(8, (RENDEROBJ)(new GStat((UI.FONT()).S)
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 101 */             GFORMAT.iIncr(text, c.available());
/*     */           }
/* 103 */         }).r(DIR.NW));
/* 104 */     s.body().incrW(48.0D);
/* 105 */     GStaples st = new GStaples(c.produced().historyRecords())
/*     */       {
/*     */         protected void hover(GBox box, int stapleI)
/*     */         {
/* 109 */           int i = c.produced().historyRecords() - 1 - stapleI;
/* 110 */           GText t = box.text();
/* 111 */           DicTime.setDaysAgo((Str)t, i);
/* 112 */           box.add((SPRITE)t);
/* 113 */           box.NL();
/* 114 */           box.add((SPRITE)GFORMAT.i(box.text(), c.produced().get(i)));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 120 */           int i = c.produced().historyRecords() - 1 - stapleI;
/* 121 */           return c.produced().get(i);
/*     */         }
/*     */       };
/* 124 */     st.body().setDim((8 * c.produced().historyRecords()), 32.0D);
/* 125 */     s.add((RENDEROBJ)st, s.body().x1(), s.body().y2() + 4);
/*     */     
/* 127 */     res.add((RENDEROBJ)s);
/*     */ 
/*     */     
/* 130 */     if ((S.get()).developer) {
/* 131 */       res.addRightC(8, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.plus)
/*     */           {
/*     */             protected void clickA() {
/* 134 */               for (RoomBlueprint b : SETT.ROOMS().all()) {
/* 135 */                 if (b instanceof settlement.room.main.RoomBlueprintIns && b instanceof AdminData.ROOM_ADMIN_HOLDER) {
/*     */                   
/* 137 */                   AdminData d = ((AdminData.ROOM_ADMIN_HOLDER)b).admin();
/* 138 */                   if (d.target == c.cu.bo) {
/* 139 */                     d.cheatAdd(500);
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           });
/*     */     }
/* 146 */     res.addRightC(8, GCOLOR.UI().border().makeSprite(1, res.body().height()));
/* 147 */     res.body().incrW(8.0D);
/*     */ 
/*     */ 
/*     */     
/* 151 */     return res;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\Info.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */