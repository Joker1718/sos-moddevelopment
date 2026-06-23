/*    */ package settlement.room.service.arena;
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GGrid;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.D;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ public class RoomArenaGui extends UIRoomModule {
/* 17 */   private static CharSequence ¤¤Executions = "Executions";
/* 18 */   private static CharSequence ¤¤ExecutionsD = "The amount of prisoners that are currently being executed."; private final RoomArenaWork w;
/*    */   
/*    */   static {
/* 21 */     D.ts(RoomArenaGui.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public RoomArenaGui(RoomArenaWork w) {
/* 27 */     this.w = w;
/*    */   }
/*    */ 
/*    */   
/*    */   public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/* 32 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 36 */             GFORMAT.iofk(text, RoomArenaGui.this.w.executions((RoomInstance)get.get()), RoomArenaGui.this.w.executionsMax((RoomInstance)get.get()));
/*    */           }
/* 38 */         }).hh(¤¤Executions).hoverInfoSet(¤¤ExecutionsD));
/*    */   }
/*    */ 
/*    */   
/*    */   public void appendManageScr(GGrid icons, GGrid text, GuiSection extra) {
/* 43 */     icons.add((RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 47 */             GFORMAT.iofk(text, RoomArenaGui.this.w.executions(), RoomArenaGui.this.w.executionsMax());
/*    */           }
/* 49 */         }).hh((SPRITE)(UI.icons()).s.death).hoverTitleSet(¤¤Executions).hoverInfoSet(¤¤ExecutionsD));
/*    */ 
/*    */     
/* 52 */     super.appendManageScr(icons, text, extra);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\arena\RoomArenaGui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */