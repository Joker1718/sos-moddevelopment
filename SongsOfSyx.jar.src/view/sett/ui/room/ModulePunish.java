/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.room.law.PUNISHMENT_SERVICE;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ final class ModulePunish
/*     */   implements Modules.ModuleMaker {
/*  30 */   private static CharSequence ¤¤Punishments = "¤Punishments";
/*  31 */   private static CharSequence ¤¤PunishmentsDesc = "¤The current and total amount of punishments in use.";
/*  32 */   private static CharSequence ¤¤Set = "¤Toggle usage for {0} prisoners.";
/*     */   
/*     */   static {
/*  35 */     D.ts(ModulePunish.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ModulePunish(Init init) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void make(RoomBlueprint p, LISTE<UIRoomModule> l) {
/*  46 */     if (p instanceof PUNISHMENT_SERVICE) {
/*  47 */       l.add(new I((PUNISHMENT_SERVICE)p));
/*     */     }
/*     */   }
/*     */   
/*     */   private class I
/*     */     extends UIRoomModule
/*     */   {
/*     */     private final PUNISHMENT_SERVICE pun;
/*     */     
/*     */     I(PUNISHMENT_SERVICE blue) {
/*  57 */       this.pun = blue;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendManageScr(GGrid grid, GGrid text, GuiSection sExta) {
/*  63 */       GuiSection s = new GuiSection();
/*     */ 
/*     */ 
/*     */       
/*  67 */       final CharSequence name = (this.pun.punishEnabled() == null) ? ModulePunish.¤¤Punishments : (this.pun.punishEnabled().info()).name;
/*  68 */       final CharSequence desc = (this.pun.punishEnabled() == null) ? ModulePunish.¤¤PunishmentsDesc : (this.pun.punishEnabled().info()).desc;
/*     */       
/*  70 */       if (this.pun.punishEnabled() != null) {
/*  71 */         for (Race r : RACES.all()) {
/*  72 */           GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)(r.appearance()).icon)
/*     */             {
/*     */               protected void clickA()
/*     */               {
/*  76 */                 ModulePunish.I.this.pun.punishEnabled().toggle(r);
/*     */               }
/*     */ 
/*     */               
/*     */               protected void renAction() {
/*  81 */                 selectedSet(ModulePunish.I.this.pun.punishEnabled().is(r));
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/*  86 */                 text.text((CharSequence)Str.TMP.clear().add(ModulePunish.¤¤Set).insert(0, r.info.namePosessive));
/*     */               }
/*     */             };
/*     */           
/*  90 */           s.addGrid((RENDEROBJ)buttPanel, r.index(), 8, 0, 0);
/*     */         } 
/*     */       }
/*     */       
/*  94 */       HOVERABLE hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  98 */             GFORMAT.iofkNoColor(text, ModulePunish.I.this.pun.punishUsed(), ModulePunish.I.this.pun.punishTotal());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 103 */             b.title(name);
/* 104 */             b.text(desc);
/*     */           }
/* 106 */         }).hh(name);
/* 107 */       s.addRelBody(4, DIR.N, (RENDEROBJ)hOVERABLE);
/*     */       
/* 109 */       text.add((RENDEROBJ)s);
/*     */     }
/*     */     
/*     */     public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */     
/*     */     public void appendButt(GuiSection s, GETTER<RoomInstance> get) {}
/*     */     
/*     */     public void hover(GBox box, Room room, int rx, int ry) {}
/*     */     
/*     */     public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room room, int rx, int ry) {}
/*     */     
/*     */     public void appendPanel(GuiSection section, GETTER<RoomInstance> get, int x1, int y1) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModulePunish.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */