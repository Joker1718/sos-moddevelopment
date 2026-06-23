/*     */ package settlement.room.knowledge.school;
/*     */ 
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends UIRoomModule
/*     */ {
/*     */   public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/* 107 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 111 */             GFORMAT.f0(text, RoomEducationHelper.null.access$0(RoomEducationHelper.null.this).learningSpeed((RoomInstance)get.get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 116 */             b.title((RoomEducationHelper.null.access$0(RoomEducationHelper.null.this)).bonus.name);
/* 117 */             b.text((RoomEducationHelper.null.access$0(RoomEducationHelper.null.this)).bonus.desc);
/* 118 */             b.NL();
/*     */             
/* 120 */             IndustryUtil.hoverProductionRate((GUI_BOX)b, 1.0D, (RoomEducationHelper.null.access$0(RoomEducationHelper.null.this)).rate, (RoomInstance)get.get());
/*     */           }
/* 135 */         }).hh((SPRITE)RoomEducationHelper.this.bonus.icon));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendManageScr(GGrid icons, GGrid text, GuiSection extra) {
/* 141 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/* 143 */     for (HCLASS_RACE rr : HCLASS_RACE.ALL()) {
/* 144 */       if (rr.race == null)
/*     */         continue; 
/* 146 */       if (rr.race.bvalue(RoomEducationHelper.this.bonus) == 0.0D)
/*     */         continue; 
/* 148 */       if (rr.cl == HCLASSES.CITIZEN()) {
/* 149 */         rows.add(new RoomEducationHelper.RaceRow(HCLASS_RACE.clP(rr.race, RoomEducationHelper.this.cl), RoomEducationHelper.this.bonus, RoomEducationHelper.this.type()));
/*     */       }
/*     */     } 
/* 152 */     text.add((RENDEROBJ)(new GScrollRows((Iterable)rows, ((RENDEROBJ)rows.get(0)).body().height() * 5)).view());
/*     */   }
/*     */   
/*     */   public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */   
/*     */   public void appendButt(GuiSection s, GETTER<RoomInstance> get) {}
/*     */   
/*     */   public void hover(GBox box, Room room, int rx, int ry) {}
/*     */   
/*     */   public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room room, int rx, int ry) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\RoomEducationHelper$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */