/*     */ package org.lwjgl.system.macosx;public class CoreGraphics { public static final int kCGErrorSuccess = 0; public static final int kCGErrorFailure = 1000; public static final int kCGErrorIllegalArgument = 1001; public static final int kCGErrorInvalidConnection = 1002;
/*     */   public static final int kCGErrorInvalidContext = 1003;
/*     */   public static final int kCGErrorCannotComplete = 1004;
/*     */   public static final int kCGErrorNotImplemented = 1006;
/*     */   public static final int kCGErrorRangeCheck = 1007;
/*     */   public static final int kCGErrorTypeCheck = 1008;
/*     */   public static final int kCGErrorInvalidOperation = 1010;
/*     */   public static final int kCGErrorNoneAvailable = 1011;
/*     */   public static final int kCGEventNull = 0;
/*     */   public static final int kCGEventLeftMouseDown = 1;
/*     */   public static final int kCGEventLeftMouseUp = 2;
/*     */   public static final int kCGEventRightMouseDown = 3;
/*     */   public static final int kCGEventRightMouseUp = 4;
/*     */   public static final int kCGEventMouseMoved = 5;
/*     */   public static final int kCGEventLeftMouseDragged = 6;
/*     */   public static final int kCGEventRightMouseDragged = 7;
/*     */   public static final int kCGEventKeyDown = 10;
/*     */   public static final int kCGEventKeyUp = 11;
/*     */   public static final int kCGEventFlagsChanged = 12;
/*     */   public static final int kCGEventScrollWheel = 22;
/*     */   public static final int kCGEventTabletPointer = 23;
/*     */   public static final int kCGEventTabletProximity = 24;
/*  23 */   private static final SharedLibrary COREGRAPHICS = Library.loadNative(CoreGraphics.class, "org.lwjgl", "/System/Library/Frameworks/CoreGraphics.framework"); public static final int kCGEventOtherMouseDown = 25; public static final int kCGEventOtherMouseUp = 26; public static final int kCGEventOtherMouseDragged = 27; public static final int kCGEventTapDisabledByTimeout = -2; public static final int kCGEventTapDisabledByUserInput = -1; public static final int kCGMouseButtonLeft = 0; public static final int kCGMouseButtonRight = 1; public static final int kCGMouseButtonCenter = 2; public static final int kCGHIDEventTap = 0; public static final int kCGSessionEventTap = 1; public static final int kCGAnnotatedSessionEventTap = 2; public static final int kCGScrollEventUnitPixel = 0; public static final int kCGScrollEventUnitLine = 1; public static final int kCGMouseEventNumber = 0; public static final int kCGMouseEventClickState = 1; public static final int kCGMouseEventPressure = 2; public static final int kCGMouseEventButtonNumber = 3; public static final int kCGMouseEventDeltaX = 4; public static final int kCGMouseEventDeltaY = 5; public static final int kCGMouseEventInstantMouser = 6; public static final int kCGMouseEventSubtype = 7; public static final int kCGKeyboardEventAutorepeat = 8; public static final int kCGKeyboardEventKeycode = 9; public static final int kCGKeyboardEventKeyboardType = 10; public static final int kCGScrollWheelEventDeltaAxis1 = 11; public static final int kCGScrollWheelEventDeltaAxis2 = 12; public static final int kCGScrollWheelEventDeltaAxis3 = 13; public static final int kCGScrollWheelEventFixedPtDeltaAxis1 = 93; public static final int kCGScrollWheelEventFixedPtDeltaAxis2 = 94; public static final int kCGScrollWheelEventFixedPtDeltaAxis3 = 95; public static final int kCGScrollWheelEventPointDeltaAxis1 = 96; public static final int kCGScrollWheelEventPointDeltaAxis2 = 97; public static final int kCGScrollWheelEventPointDeltaAxis3 = 98; public static final int kCGScrollWheelEventScrollPhase = 99; public static final int kCGScrollWheelEventScrollCount = 100; public static final int kCGScrollWheelEventMomentumPhase = 123; public static final int kCGScrollWheelEventInstantMouser = 14; public static final int kCGTabletEventPointX = 15; public static final int kCGTabletEventPointY = 16; public static final int kCGTabletEventPointZ = 17; public static final int kCGTabletEventPointButtons = 18; public static final int kCGTabletEventPointPressure = 19; public static final int kCGTabletEventTiltX = 20; public static final int kCGTabletEventTiltY = 21; public static final int kCGTabletEventRotation = 22; public static final int kCGTabletEventTangentialPressure = 23; public static final int kCGTabletEventDeviceID = 24; public static final int kCGTabletEventVendor1 = 25; public static final int kCGTabletEventVendor2 = 26; public static final int kCGTabletEventVendor3 = 27; public static final int kCGTabletProximityEventVendorID = 28; public static final int kCGTabletProximityEventTabletID = 29; public static final int kCGTabletProximityEventPointerID = 30; public static final int kCGTabletProximityEventDeviceID = 31; public static final int kCGTabletProximityEventSystemTabletID = 32; public static final int kCGTabletProximityEventVendorPointerType = 33; public static final int kCGTabletProximityEventVendorPointerSerialNumber = 34; public static final int kCGTabletProximityEventVendorUniqueID = 35; public static final int kCGTabletProximityEventCapabilityMask = 36; public static final int kCGTabletProximityEventPointerType = 37; public static final int kCGTabletProximityEventEnterProximity = 38; public static final int kCGEventTargetProcessSerialNumber = 39; public static final int kCGEventTargetUnixProcessID = 40; public static final int kCGEventSourceUnixProcessID = 41; public static final int kCGEventSourceUserData = 42; public static final int kCGEventSourceUserID = 43; public static final int kCGEventSourceGroupID = 44;
/*     */   public static final int kCGEventSourceStateID = 45;
/*     */   public static final int kCGScrollWheelEventIsContinuous = 88;
/*     */   public static final int kCGMouseEventWindowUnderMousePointer = 91;
/*     */   public static final int kCGMouseEventWindowUnderMousePointerThatCanHandleThisEvent = 92;
/*     */   public static final int kCGEventMouseSubtypeDefault = 0;
/*     */   public static final int kCGEventMouseSubtypeTabletPoint = 1;
/*     */   public static final int kCGEventMouseSubtypeTabletProximity = 2;
/*     */   
/*  32 */   public static final class Functions { public static final long EventGetTypeID = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetTypeID");
/*  33 */     public static final long EventCreate = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreate");
/*  34 */     public static final long EventCreateData = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateData");
/*  35 */     public static final long EventCreateFromData = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateFromData");
/*  36 */     public static final long EventCreateMouseEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateMouseEvent");
/*  37 */     public static final long EventCreateKeyboardEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateKeyboardEvent");
/*  38 */     public static final long EventCreateScrollWheelEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateScrollWheelEvent");
/*  39 */     public static final long EventCreateScrollWheelEvent2 = APIUtil.apiGetFunctionAddressOptional(CoreGraphics.COREGRAPHICS, "CGEventCreateScrollWheelEvent2");
/*  40 */     public static final long EventCreateCopy = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateCopy");
/*  41 */     public static final long EventCreateSourceFromEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventCreateSourceFromEvent");
/*  42 */     public static final long EventSetSource = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetSource");
/*  43 */     public static final long EventGetType = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetType");
/*  44 */     public static final long EventSetType = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetType");
/*  45 */     public static final long EventGetTimestamp = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetTimestamp");
/*  46 */     public static final long EventSetTimestamp = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetTimestamp");
/*  47 */     public static final long EventGetLocation = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetLocation");
/*  48 */     public static final long EventGetUnflippedLocation = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetUnflippedLocation");
/*  49 */     public static final long EventSetLocation = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetLocation");
/*  50 */     public static final long EventGetFlags = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetFlags");
/*  51 */     public static final long EventSetFlags = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetFlags");
/*  52 */     public static final long EventKeyboardGetUnicodeString = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventKeyboardGetUnicodeString");
/*  53 */     public static final long EventKeyboardSetUnicodeString = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventKeyboardSetUnicodeString");
/*  54 */     public static final long EventGetIntegerValueField = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetIntegerValueField");
/*  55 */     public static final long EventSetIntegerValueField = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetIntegerValueField");
/*  56 */     public static final long EventGetDoubleValueField = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventGetDoubleValueField");
/*  57 */     public static final long EventSetDoubleValueField = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventSetDoubleValueField");
/*  58 */     public static final long EventTapCreate = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventTapCreate");
/*  59 */     public static final long EventTapCreateForPid = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventTapCreateForPid");
/*  60 */     public static final long EventTapEnable = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventTapEnable");
/*  61 */     public static final long EventTapIsEnabled = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventTapIsEnabled");
/*  62 */     public static final long EventTapPostEvent = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventTapPostEvent");
/*  63 */     public static final long EventPost = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventPost");
/*  64 */     public static final long EventPostToPid = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGEventPostToPid");
/*  65 */     public static final long GetEventTapList = APIUtil.apiGetFunctionAddress((FunctionProvider)CoreGraphics.COREGRAPHICS, "CGGetEventTapList"); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SharedLibrary getLibrary() {
/*  71 */     return COREGRAPHICS;
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
/*     */   protected CoreGraphics() {
/* 188 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CFTypeID")
/*     */   public static long CGEventGetTypeID() {
/* 196 */     long __functionAddress = Functions.EventGetTypeID;
/* 197 */     return JNI.invokeJ(__functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreate(@NativeType("CGEventSourceRef") long source) {
/* 205 */     long __functionAddress = Functions.EventCreate;
/* 206 */     return JNI.invokePP(source, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CFDataRef")
/*     */   public static long CGEventCreateData(@NativeType("CFAllocatorRef") long allocator, @NativeType("CGEventRef") long event) {
/* 214 */     long __functionAddress = Functions.EventCreateData;
/* 215 */     return JNI.invokePPP(allocator, event, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateFromData(@NativeType("CFAllocatorRef") long allocator, @NativeType("CFDataRef") long data) {
/* 223 */     long __functionAddress = Functions.EventCreateFromData;
/* 224 */     return JNI.invokePPP(allocator, data, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nCGEventCreateMouseEvent(long source, int mouseType, long mouseCursorPosition, int mouseButton) {
/* 234 */     long __functionAddress = Functions.EventCreateMouseEvent;
/* 235 */     return nCGEventCreateMouseEvent(source, mouseType, mouseCursorPosition, mouseButton, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateMouseEvent(@NativeType("CGEventSourceRef") long source, @NativeType("CGEventType") int mouseType, CGPoint mouseCursorPosition, @NativeType("CGMouseButton") int mouseButton) {
/* 241 */     return nCGEventCreateMouseEvent(source, mouseType, mouseCursorPosition.address(), mouseButton);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateKeyboardEvent(@NativeType("CGEventSourceRef") long source, @NativeType("CGKeyCode") short virtualKey, @NativeType("bool") boolean keyDown) {
/* 249 */     long __functionAddress = Functions.EventCreateKeyboardEvent;
/* 250 */     return JNI.invokePCP(source, virtualKey, keyDown, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateScrollWheelEvent(@NativeType("CGEventSourceRef") long source, @NativeType("CGScrollEventUnit") int units, @NativeType("uint32_t") int wheelCount, @NativeType("int32_t") int wheel1) {
/* 258 */     long __functionAddress = Functions.EventCreateScrollWheelEvent;
/* 259 */     return JNI.invokePP(source, units, wheelCount, wheel1, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateScrollWheelEvent(@NativeType("CGEventSourceRef") long source, @NativeType("CGScrollEventUnit") int units, @NativeType("int32_t") int wheel1) {
/* 265 */     long __functionAddress = Functions.EventCreateScrollWheelEvent;
/* 266 */     return JNI.invokePP(source, units, 1, wheel1, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateScrollWheelEvent2(@NativeType("CGEventSourceRef") long source, @NativeType("CGScrollEventUnit") int units, @NativeType("uint32_t") int wheelCount, @NativeType("int32_t") int wheel1, @NativeType("int32_t") int wheel2, @NativeType("int32_t") int wheel3) {
/* 274 */     long __functionAddress = Functions.EventCreateScrollWheelEvent2;
/* 275 */     if (Checks.CHECKS) {
/* 276 */       Checks.check(__functionAddress);
/*     */     }
/* 278 */     return JNI.invokePP(source, units, wheelCount, wheel1, wheel2, wheel3, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventRef")
/*     */   public static long CGEventCreateCopy(@NativeType("CGEventRef") long event) {
/* 286 */     long __functionAddress = Functions.EventCreateCopy;
/* 287 */     return JNI.invokePP(event, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventSourceRef")
/*     */   public static long CGEventCreateSourceFromEvent(@NativeType("CGEventRef") long event) {
/* 295 */     long __functionAddress = Functions.EventCreateSourceFromEvent;
/* 296 */     return JNI.invokePP(event, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventSetSource(@NativeType("CGEventRef") long event, @NativeType("CGEventSourceRef") long source) {
/* 303 */     long __functionAddress = Functions.EventSetSource;
/* 304 */     JNI.invokePPV(event, source, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventType")
/*     */   public static int CGEventGetType(@NativeType("CGEventRef") long event) {
/* 312 */     long __functionAddress = Functions.EventGetType;
/* 313 */     return JNI.invokePI(event, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventSetType(@NativeType("CGEventRef") long event, @NativeType("CGEventType") int type) {
/* 320 */     long __functionAddress = Functions.EventSetType;
/* 321 */     JNI.invokePV(event, type, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventTimestamp")
/*     */   public static long CGEventGetTimestamp(@NativeType("CGEventRef") long event) {
/* 329 */     long __functionAddress = Functions.EventGetTimestamp;
/* 330 */     return JNI.invokePJ(event, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventSetTimestamp(@NativeType("CGEventRef") long event, @NativeType("CGEventTimestamp") long timestamp) {
/* 337 */     long __functionAddress = Functions.EventSetTimestamp;
/* 338 */     JNI.invokePJV(event, timestamp, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nCGEventGetLocation(long event, long __result) {
/* 348 */     long __functionAddress = Functions.EventGetLocation;
/* 349 */     nCGEventGetLocation(event, __functionAddress, __result);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGPoint CGEventGetLocation(@NativeType("CGEventRef") long event, CGPoint __result) {
/* 354 */     nCGEventGetLocation(event, __result.address());
/* 355 */     return __result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nCGEventGetUnflippedLocation(long event, long __result) {
/* 365 */     long __functionAddress = Functions.EventGetUnflippedLocation;
/* 366 */     nCGEventGetUnflippedLocation(event, __functionAddress, __result);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CGPoint CGEventGetUnflippedLocation(@NativeType("CGEventRef") long event, CGPoint __result) {
/* 371 */     nCGEventGetUnflippedLocation(event, __result.address());
/* 372 */     return __result;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nCGEventSetLocation(long event, long location) {
/* 382 */     long __functionAddress = Functions.EventSetLocation;
/* 383 */     nCGEventSetLocation(event, location, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void CGEventSetLocation(@NativeType("CGEventRef") long event, CGPoint location) {
/* 388 */     nCGEventSetLocation(event, location.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CGEventFlags")
/*     */   public static long CGEventGetFlags(@NativeType("CGEventRef") long event) {
/* 396 */     long __functionAddress = Functions.EventGetFlags;
/* 397 */     return JNI.invokePJ(event, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventSetFlags(@NativeType("CGEventRef") long event, @NativeType("CGEventFlags") long flags) {
/* 404 */     long __functionAddress = Functions.EventSetFlags;
/* 405 */     JNI.invokePJV(event, flags, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nCGEventKeyboardGetUnicodeString(long event, long maxStringLength, long actualStringLength, long unicodeString) {
/* 412 */     long __functionAddress = Functions.EventKeyboardGetUnicodeString;
/* 413 */     JNI.invokePNPPV(event, maxStringLength, actualStringLength, unicodeString, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void CGEventKeyboardGetUnicodeString(@NativeType("CGEventRef") long event, @NativeType("UniCharCount *") CLongBuffer actualStringLength, @NativeType("UniChar *") ShortBuffer unicodeString) {
/* 418 */     if (Checks.CHECKS) {
/* 419 */       Checks.checkSafe((CustomBuffer)actualStringLength, 1);
/*     */     }
/* 421 */     nCGEventKeyboardGetUnicodeString(event, Checks.remainingSafe(unicodeString), MemoryUtil.memAddressSafe((Pointer)actualStringLength), MemoryUtil.memAddressSafe(unicodeString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nCGEventKeyboardSetUnicodeString(long event, long stringLength, long unicodeString) {
/* 428 */     long __functionAddress = Functions.EventKeyboardSetUnicodeString;
/* 429 */     JNI.invokePNPV(event, stringLength, unicodeString, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void CGEventKeyboardSetUnicodeString(@NativeType("CGEventRef") long event, @NativeType("UniChar const *") ShortBuffer unicodeString) {
/* 434 */     nCGEventKeyboardSetUnicodeString(event, unicodeString.remaining(), MemoryUtil.memAddress(unicodeString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("int64_t")
/*     */   public static long CGEventGetIntegerValueField(@NativeType("CGEventRef") long event, @NativeType("CGEventField") int field) {
/* 442 */     long __functionAddress = Functions.EventGetIntegerValueField;
/* 443 */     return JNI.invokePJ(event, field, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventSetIntegerValueField(@NativeType("CGEventRef") long event, @NativeType("CGEventField") int field, @NativeType("int64_t") long value) {
/* 450 */     long __functionAddress = Functions.EventSetIntegerValueField;
/* 451 */     JNI.invokePJV(event, field, value, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double CGEventGetDoubleValueField(@NativeType("CGEventRef") long event, @NativeType("CGEventField") int field) {
/* 458 */     long __functionAddress = Functions.EventGetDoubleValueField;
/* 459 */     return JNI.invokePD(event, field, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventSetDoubleValueField(@NativeType("CGEventRef") long event, @NativeType("CGEventField") int field, double value) {
/* 466 */     long __functionAddress = Functions.EventSetDoubleValueField;
/* 467 */     JNI.invokePV(event, field, value, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nCGEventTapCreate(int tap, int place, int options, long eventsOfInterest, long callback, long userInfo) {
/* 474 */     long __functionAddress = Functions.EventTapCreate;
/* 475 */     return JNI.invokeJPPP(tap, place, options, eventsOfInterest, callback, userInfo, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("CFMachPortRef")
/*     */   public static long CGEventTapCreate(@NativeType("CGEventTapLocation") int tap, @NativeType("CGEventTapPlacement") int place, @NativeType("CGEventTapOptions") int options, @NativeType("CGEventMask") long eventsOfInterest, @NativeType("CGEventRef (*) (CGEventTapProxy, CGEventType, CGEventRef, void *)") CGEventTapCallBackI callback, @NativeType("void *") long userInfo) {
/* 481 */     return nCGEventTapCreate(tap, place, options, eventsOfInterest, callback.address(), userInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nCGEventTapCreateForPid(long pid, int place, int options, long eventsOfInterest, long callback, long userInfo) {
/* 488 */     long __functionAddress = Functions.EventTapCreateForPid;
/* 489 */     if (Checks.CHECKS) {
/* 490 */       Checks.check(pid);
/*     */     }
/* 492 */     return JNI.invokePJPPP(pid, place, options, eventsOfInterest, callback, userInfo, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("CFMachPortRef")
/*     */   public static long CGEventTapCreateForPid(@NativeType("pid_t") long pid, @NativeType("CGEventTapPlacement") int place, @NativeType("CGEventTapOptions") int options, @NativeType("CGEventMask") long eventsOfInterest, @NativeType("CGEventRef (*) (CGEventTapProxy, CGEventType, CGEventRef, void *)") CGEventTapCallBackI callback, @NativeType("void *") long userInfo) {
/* 498 */     return nCGEventTapCreateForPid(pid, place, options, eventsOfInterest, callback.address(), userInfo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventTapEnable(@NativeType("CFMachPortRef") long tap, @NativeType("bool") boolean enable) {
/* 505 */     long __functionAddress = Functions.EventTapEnable;
/* 506 */     if (Checks.CHECKS) {
/* 507 */       Checks.check(tap);
/*     */     }
/* 509 */     JNI.invokePV(tap, enable, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("bool")
/*     */   public static boolean CGEventTapIsEnabled(@NativeType("CFMachPortRef") long tap) {
/* 517 */     long __functionAddress = Functions.EventTapIsEnabled;
/* 518 */     if (Checks.CHECKS) {
/* 519 */       Checks.check(tap);
/*     */     }
/* 521 */     return JNI.invokePZ(tap, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventTapPostEvent(@NativeType("CGEventTapProxy") long proxy, @NativeType("CGEventRef") long event) {
/* 528 */     long __functionAddress = Functions.EventTapPostEvent;
/* 529 */     JNI.invokePPV(proxy, event, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventPost(@NativeType("CGEventTapLocation") int tap, @NativeType("CGEventRef") long event) {
/* 536 */     long __functionAddress = Functions.EventPost;
/* 537 */     if (Checks.CHECKS) {
/* 538 */       Checks.check(event);
/*     */     }
/* 540 */     JNI.invokePV(tap, event, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CGEventPostToPid(@NativeType("pid_t") long pid, @NativeType("CGEventRef") long event) {
/* 547 */     long __functionAddress = Functions.EventPostToPid;
/* 548 */     if (Checks.CHECKS) {
/* 549 */       Checks.check(pid);
/*     */     }
/* 551 */     JNI.invokePPV(pid, event, __functionAddress);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nCGGetEventTapList(int maxNumberOfTaps, long tapList, long eventTapCount) {
/* 558 */     long __functionAddress = Functions.GetEventTapList;
/* 559 */     return JNI.invokePPI(maxNumberOfTaps, tapList, eventTapCount, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("CGError")
/*     */   public static int CGGetEventTapList(@NativeType("CGEventTapInformation *") CGEventTapInformation.Buffer tapList, @NativeType("uint32_t *") IntBuffer eventTapCount) {
/* 565 */     if (Checks.CHECKS) {
/* 566 */       Checks.checkSafe(eventTapCount, 1);
/*     */     }
/* 568 */     return nCGGetEventTapList(Checks.remainingSafe((CustomBuffer)tapList), MemoryUtil.memAddressSafe((Pointer)tapList), MemoryUtil.memAddressSafe(eventTapCount));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void CGEventKeyboardGetUnicodeString(@NativeType("CGEventRef") long event, @NativeType("UniCharCount *") CLongBuffer actualStringLength, @NativeType("UniChar *") short[] unicodeString) {
/* 573 */     long __functionAddress = Functions.EventKeyboardGetUnicodeString;
/* 574 */     if (Checks.CHECKS) {
/* 575 */       Checks.checkSafe((CustomBuffer)actualStringLength, 1);
/*     */     }
/* 577 */     JNI.invokePNPPV(event, Checks.lengthSafe(unicodeString), MemoryUtil.memAddressSafe((Pointer)actualStringLength), unicodeString, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void CGEventKeyboardSetUnicodeString(@NativeType("CGEventRef") long event, @NativeType("UniChar const *") short[] unicodeString) {
/* 582 */     long __functionAddress = Functions.EventKeyboardSetUnicodeString;
/* 583 */     JNI.invokePNPV(event, unicodeString.length, unicodeString, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("CGError")
/*     */   public static int CGGetEventTapList(@NativeType("CGEventTapInformation *") CGEventTapInformation.Buffer tapList, @NativeType("uint32_t *") int[] eventTapCount) {
/* 589 */     long __functionAddress = Functions.GetEventTapList;
/* 590 */     if (Checks.CHECKS) {
/* 591 */       Checks.checkSafe(eventTapCount, 1);
/*     */     }
/* 593 */     return JNI.invokePPI(Checks.remainingSafe((CustomBuffer)tapList), MemoryUtil.memAddressSafe((Pointer)tapList), eventTapCount, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native long nCGEventCreateMouseEvent(long paramLong1, int paramInt1, long paramLong2, int paramInt2, long paramLong3);
/*     */   
/*     */   public static native void nCGEventGetLocation(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nCGEventGetUnflippedLocation(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nCGEventSetLocation(long paramLong1, long paramLong2, long paramLong3); }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\CoreGraphics.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */