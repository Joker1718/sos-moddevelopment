/*    */ package settlement.room.health.hospital;
/*    */ import game.faction.FACTIONS;
/*    */ import init.resources.RESOURCE;
/*    */ import init.value.Lockable;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sets.Stack;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GButt;
/*    */ import view.sett.ui.room.UIRoomModule;
/*    */ 
/*    */ class Gui extends UIRoomModule.UIRoomModuleImp<HospitalInstance, ROOM_HOSPITAL> {
/* 19 */   private static CharSequence ¤¤nn = "Fetch:";
/* 20 */   private static CharSequence ¤¤hov = "Allowing this resource use increases recovery rate by 75%";
/*    */   
/*    */   static {
/* 23 */     D.ts(Gui.class);
/*    */   }
/*    */   
/*    */   Gui(ROOM_HOSPITAL s) {
/* 27 */     super(s);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<HospitalInstance> getter, int x1, int y1) {
/* 35 */     GuiSection s = new GuiSection();
/*    */ 
/*    */     
/* 38 */     for (int i = 0; i < ((ROOM_HOSPITAL)this.blueprint).consumtion.ins().size(); i++) {
/* 39 */       RESOURCE res = ((IndustryResource)((ROOM_HOSPITAL)this.blueprint).consumtion.ins().get(i)).resource;
/* 40 */       final int k = i;
/* 41 */       GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)res.icon())
/*    */         {
/*    */           protected void renAction()
/*    */           {
/* 45 */             selectedSet(((HospitalInstance)getter.get()).fetch[k]);
/* 46 */             activeSet(((Lockable)((ROOM_HOSPITAL)Gui.this.blueprint).resLocks.get(k)).passes(FACTIONS.player()));
/*    */           }
/*    */ 
/*    */           
/*    */           protected void clickA() {
/* 51 */             ((HospitalInstance)getter.get()).fetch[k] = !((HospitalInstance)getter.get()).fetch[k];
/*    */           }
/*    */ 
/*    */           
/*    */           public void hoverInfoGet(GUI_BOX text) {
/* 56 */             super.hoverInfoGet(text);
/* 57 */             text.NL();
/* 58 */             ((Lockable)((ROOM_HOSPITAL)Gui.this.blueprint).resLocks.get(k)).hover(text, FACTIONS.player());
/*    */           }
/*    */         };
/*    */ 
/*    */       
/* 63 */       b.hoverTitleSet(String.valueOf(¤¤nn) + " " + String.valueOf(¤¤nn));
/* 64 */       b.hoverInfoSet(¤¤hov);
/* 65 */       b.pad(16, 4);
/* 66 */       s.addRightC(0, (RENDEROBJ)b);
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 71 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void problem(HospitalInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/* 80 */     super.problem(i, free, errors, warnings);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */