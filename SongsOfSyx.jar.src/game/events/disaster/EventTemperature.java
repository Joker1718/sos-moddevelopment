/*    */ package game.events.disaster;
/*    */ 
/*    */ import game.events.EVENTS;
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.text.D;
/*    */ import view.sett.IDebugPanelSett;
/*    */ import view.ui.message.MessageText;
/*    */ 
/*    */ public final class EventTemperature
/*    */   extends EVENTS.EventResource
/*    */ {
/* 19 */   private static CharSequence ¤¤ExtremeTemp = "Extreme Temperatures";
/* 20 */   private static CharSequence ¤¤ExtremeTempHot = "The temperature is rising to an extreme level today. Make sure you have ways for subjects to cool down!";
/* 21 */   private static CharSequence ¤¤ExtremeTempCold = "The temperature has plunged to record lows. Make sure our hearths are stocked with wood.";
/*    */   static {
/* 23 */     D.ts(EventTemperature.class);
/*    */   }
/*    */   
/* 26 */   private int dayLast = -1;
/*    */   
/*    */   public EventTemperature() {
/* 29 */     super("TEMP");
/* 30 */     IDebugPanelSett.add("Event: Temp", new ACTION()
/*    */         {
/*    */           public void exe()
/*    */           {
/* 34 */             EventTemperature.this.event(0.2D, (SETT.WEATHER()).temp.average(TIME.years().bitPartOf()));
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update(double ds) {
/* 41 */     if (this.dayLast != TIME.days().bitsSinceStart()) {
/* 42 */       this.dayLast = TIME.days().bitsSinceStart();
/* 43 */       if (TIME.days().bitsSinceStart() > 6) {
/* 44 */         double ave = (SETT.WEATHER()).temp.average(TIME.years().bitPartOf());
/* 45 */         double ran = RND.rFloat();
/* 46 */         for (int i = 0; i < 5; i++) {
/* 47 */           ran *= ran;
/*    */         }
/* 49 */         ran *= 0.25D;
/*    */         
/* 51 */         if (ran > 0.15D) {
/* 52 */           event(ran, ave);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void event(double ran, double ave) {
/* 61 */     if (ave < 0.5D) {
/* 62 */       (SETT.WEATHER()).temp.setTarget(CLAMP.d(ave - ran, 0.0D, 1.0D));
/* 63 */       (new MessageText(¤¤ExtremeTemp, ¤¤ExtremeTempCold)).send();
/*    */     } else {
/* 65 */       (SETT.WEATHER()).temp.setTarget(CLAMP.d(ave + ran, 0.0D, 1.0D));
/* 66 */       (new MessageText(¤¤ExtremeTemp, ¤¤ExtremeTempHot)).send();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void save(FilePutter file) {
/* 72 */     file.i(this.dayLast);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 77 */     this.dayLast = file.i();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clear() {
/* 82 */     this.dayLast = -1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\disaster\EventTemperature.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */